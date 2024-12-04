package org.eun.e_blog.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eun.e_blog.common.constants.APIResponseMessage;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.user.dto.request.CreateUserAccountRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag( name = "Account API", description = "계정 관련 API")
public interface AccountController {
    @Operation( summary = "회원가입 API", description = "회원가입을 위한 API" )
    @ApiResponses( value = {
            @ApiResponse (
                    responseCode = APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @PostMapping( "/signIn" )
    ResponseEntity<SuccessResponse<Void>> createUserAccount(
            @RequestBody CreateUserAccountRequest createUserAccountRequest
    );

    @Operation( summary = "로그인 API", description = "로그인을 위한 API" )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @PostMapping( "/login" )
    ResponseEntity<SuccessResponse<Long>> login(
            @RequestParam String email,
            @RequestParam String password
    );
}
