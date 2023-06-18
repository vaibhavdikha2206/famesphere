package com.example.famesphere.security.services;

import com.example.famesphere.security.models.ProfileUser;
import com.example.famesphere.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("authentication for "+userid);
		Optional<ProfileUser> user = userRepository.findByUserid(userid);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found " + userid));
		return user.map(MyUserDetails::new).get();
		
	}

}
