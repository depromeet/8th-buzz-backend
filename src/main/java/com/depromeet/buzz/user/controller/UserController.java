package com.depromeet.buzz.user.controller;

import com.depromeet.buzz.user.dto.UserResponse;
import com.depromeet.buzz.user.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    @ApiResponse(description = "현재 로그인된 유저 정보 가져오기")
    @Parameters(value = {
            @Parameter(name = "User-ID", description = "유저아이디 정보", in = ParameterIn.HEADER)
    })
    public ResponseEntity<UserResponse> getUser(@RequestHeader("User-ID") String userId) {

        return ResponseEntity.ok(userService.findUserInfo(userId));
    }
}
