package com.example.famesphere.repositories;

import com.example.famesphere.models.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<Profile, String> {

}
