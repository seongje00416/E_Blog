package org.eun.e_blog.user.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.user.controller.UserController;
import org.eun.e_blog.user.dto.request.UpdateUserRequest;
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

    @Override
    public ResponseEntity<SuccessResponse<Void>> deleteUser(Long userID) {
        userService.deleteUser( userID );
        return SuccessResponse.ofNoData().asHttp( HttpStatus.OK );
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> updateUser( Long userID, UpdateUserRequest updateUserRequest) {
        userService.updateUser( userID, updateUserRequest );
        return SuccessResponse.ofNoData().asHttp( HttpStatus.OK );
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> addFriend(Long userID, Long friendID) {
        userService.addFriend( userID, friendID );
        return SuccessResponse.ofNoData().asHttp( HttpStatus.OK );
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> assignFriend(Long assignID, String assignResult) {
        userService.assignFriend( assignID, assignResult );
        return SuccessResponse.ofNoData().asHttp( HttpStatus.OK );
    }
}
