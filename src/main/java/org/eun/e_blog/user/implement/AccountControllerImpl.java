package org.eun.e_blog.user.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.user.controller.AccountController;
import org.eun.e_blog.user.dto.request.CreateUserAccountRequest;
import org.eun.e_blog.user.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/account" )
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;

    @Override
    public ResponseEntity<SuccessResponse<Void>> createUserAccount(CreateUserAccountRequest createUserAccountRequest) {
        this.accountService.createUserAccount(createUserAccountRequest);
        return SuccessResponse.ofNoData().asHttp(HttpStatus.OK );
    }
}
