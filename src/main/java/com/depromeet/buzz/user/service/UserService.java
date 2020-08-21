package com.depromeet.buzz.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

}
