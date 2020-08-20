package com.depromeet.buzz.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.buzz.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(String userId);
}
