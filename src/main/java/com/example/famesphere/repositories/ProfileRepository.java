package com.example.famesphere.repositories;

import com.example.famesphere.models.user.response.ProfileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProfileRepository extends JpaRepository<ProfileResponse,String> {
	
	@Query(value="Select userid from profile where userid = :userid",nativeQuery = true)
	ProfileResponse findByUseridCustom(@Param("userid")String userid);

	@Modifying
	@Query(value="Update profile set instausername = :instausername , instafollower = :igfollowers , ytsubscribers = :ytsubscribers where userid = :userid",nativeQuery = true)
	Integer updateFollowerCount(@Param("userid")String userid,@Param("instausername")String instausername,@Param("igfollowers")int igfollowers,@Param("ytsubscribers")int ytsubscribers);
}