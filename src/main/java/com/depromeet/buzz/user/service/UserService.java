package com.depromeet.buzz.user.service;

import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.dto.UserResponse;
import com.depromeet.buzz.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException(String.format("유저를 찾을 수 없습니다 userId: %s", userId)));
    }

    public UserResponse findUserInfo(String userId) {
        User user = findByUserId(userId);
        return UserResponse.from(user);
    }
}
