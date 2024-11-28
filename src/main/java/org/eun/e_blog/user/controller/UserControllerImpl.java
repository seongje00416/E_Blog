package org.eun.e_blog.user.controller;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.user.dto.response.GetUserDetailResponse;
import org.eun.e_blog.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<SuccessResponse<GetUserDetailResponse>> getUserDetail(Long userID) {
        return SuccessResponse.of(userService.getUserDetail( userID ) ).asHttp( HttpStatus.OK );
    }
}
