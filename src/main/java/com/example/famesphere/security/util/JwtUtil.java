 package com.example.famesphere.security.util;

 import com.example.famesphere.security.services.MyUserDetails;
 import io.jsonwebtoken.Claims;
 import io.jsonwebtoken.Jwts;
 import io.jsonwebtoken.SignatureAlgorithm;
 import org.springframework.stereotype.Service;

 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.function.Function;

 @Service
 public class JwtUtil {

     private String SECRET_KEY = "secret";

     public String extractUsername(String token) {
         return extractClaim(token, Claims::getSubject);
     }

     public String extractRole(String token) {
    	 final Claims claims = extractAllClaims(token);
    	 return claims.get("role",String.class);
     }
     
     public Integer extractLocationcode(String token) {
    	 final Claims claims = extractAllClaims(token);
    	 return claims.get("locationcode",Integer.class);
     }
     
     public Date extractExpiration(String token) {
         return extractClaim(token, Claims::getExpiration);
     }

     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
         final Claims claims = extractAllClaims(token);
         return claimsResolver.apply(claims);
     }
     private Claims extractAllClaims(String token) {
         return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
     }

     private Boolean isTokenExpired(String token) {
         return extractExpiration(token).before(new Date());
     }

     public String generateToken(MyUserDetails userDetails) {
         Map<String, Object> claims = new HashMap<>();
         return createToken(claims, userDetails.getUsername());
     }

     private String createToken(Map<String, Object> claims, String subject) {
         return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                 .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
     }

     public Boolean validateToken(String token, MyUserDetails userDetails) {
         final String username = extractUsername(token);
         return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
     }
 }
