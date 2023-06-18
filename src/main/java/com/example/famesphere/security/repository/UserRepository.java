package com.example.famesphere.security.repository;

import com.example.famesphere.security.models.ProfileUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<ProfileUser, String> {

	Optional<ProfileUser> findByUserid(String userid);
}
