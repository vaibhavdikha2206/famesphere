package com.example.famesphere.authentication;

import com.example.famesphere.models.updateFollower.request.UpdateFollowersRequestObject;
import com.example.famesphere.models.updateFollower.response.UpdateFollowersResponseObject;
import com.example.famesphere.models.user.response.SignUpResponseObject;
import com.example.famesphere.repositories.ProfileRepository;
import com.example.famesphere.repositories.SignUpRepository;
import com.example.famesphere.security.services.MyUserDetails;
import com.example.famesphere.security.services.MyUserDetailsService;
import com.example.famesphere.security.util.JwtUtil;
import com.example.famesphere.models.user.Profile;
import com.example.famesphere.models.user.request.SignUpObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private static final String keySign = "abcxyz";

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Transactional
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public SignUpResponseObject signUp(@RequestBody SignUpObject signUpObject) throws JpaSystemException, Exception {

        if(signUpObject.getSignkey().equals(keySign)) {
            System.out.println("Signup "+","+signUpObject.getUserid()+","+signUpObject.getPassword());
        }
        else {
            throw new Exception("Sorry,cant Sign Up , Please Try Again");
        }

        if(profileRepository.findByUseridCustom(signUpObject.getUserid())!=null) {
            throw new Exception("Username Already Exists");
        }
        //if its from referral code add credits to profile and then register

        Profile profile ;

        profile = new Profile(signUpObject.getUserid(),signUpObject.getPassword(),signUpObject.getEmail(),null,null);
        return new SignUpResponseObject(signUpRepository.save(profile),generateJwtToken(profile.getUserid(),profile.getPassword()));
    }

    private String generateJwtToken(String userId,String password) throws Exception {
        try {
            System.out.println("ok "+userId+","+password);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userId, password)
            );
        }
        catch (BadCredentialsException e) {
            System.out.println("error in /Authenticate"+e);
            throw new Exception("Incorrect username or password", e);
        }

        final MyUserDetails userDetails = (MyUserDetails) userDetailsService.loadUserByUsername(userId);
        final String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }

    @Transactional
    @RequestMapping(method=RequestMethod.POST,value="/updateFollowerCount")
    public UpdateFollowersResponseObject initiateExpressDelivery(@RequestBody UpdateFollowersRequestObject updateFollowersRequestObject, @RequestHeader (name="Authorization") String authorizationHeader) throws Exception {
        String jwt = authorizationHeader.substring(7);
        String userid = jwtUtil.extractUsername(jwt);
        System.out.println("userid 1 "+userid);

        //int locationcode = jwtUtil.extractLocationcode(jwt);

        System.out.println("userid 2 "+userid);
        Integer status = profileRepository.updateFollowerCount(userid,updateFollowersRequestObject.getIgfollowers(),updateFollowersRequestObject.getYtsubscribers());

        return new UpdateFollowersResponseObject(userid,status);

    }

}