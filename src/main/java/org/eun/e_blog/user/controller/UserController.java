package org.eun.e_blog.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.user.dto.request.UpdateUserRequest;
import org.eun.e_blog.user.dto.response.GetUserDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam Long userID
    );

    @Operation( summary = "유저 정보 삭제", description = "userID를 통한 유저 정보 삭제")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "작업을 성공적으로 수행했습니다."
            )
    })
    @DeleteMapping( "/{userID}" )
    ResponseEntity<SuccessResponse<Void>> deleteUser(
            @RequestParam Long userID
    );
    
    @Operation( summary = "유저 정보 수정", description = "유저 정보 수정")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "작업을 성공적으로 수행했습니다"
            )
    })
    @PatchMapping( "/{userID}" )
    ResponseEntity<SuccessResponse<Void>> updateUser(
            @RequestParam Long userID,
            @RequestBody UpdateUserRequest updateUserRequest
    );

    @Operation( summary = "친구 신청", description = "유저 사이의 친구 등록" )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "작업을 성공적으로 수행했습니다"
            )
    })
    @PostMapping( "/friend" )
    ResponseEntity<SuccessResponse<Void>> addFriend(
            @RequestParam Long userID,
            @RequestParam Long friendID
    );

    @Operation( summary = "친구 신청 응답", description = "받은 친구 신청에 대한 응답" )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "작업을 성공적으로 수행했습니다"
            )
    })
    @PatchMapping( "/friend/{assignID}" )
    ResponseEntity<SuccessResponse<Void>> assignFriend(
      @RequestParam Long assignID,
      @RequestParam String assignResult
    );
}
