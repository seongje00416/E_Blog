package org.eun.e_blog.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.user.dto.response.GetUserDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag( name="USER API", description="사용자 정보 관련 API")
public interface UserController {
    @Operation(summary = "유저 정보 조회", description = "userID를 통한 유저 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "작업을 성공적으로 수행했습니다.")
    })
    @GetMapping("/{userID}")
    ResponseEntity<SuccessResponse<GetUserDetailResponse>> getUserDetail(
            @PathVariable Long userID
    );
}
