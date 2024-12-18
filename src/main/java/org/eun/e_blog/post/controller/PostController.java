package org.eun.e_blog.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eun.e_blog.common.constants.APIResponseMessage;
import org.eun.e_blog.common.dto.response.PageResponse;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.dto.request.CreatePostRequest;
import org.eun.e_blog.post.dto.response.GetPostDetailResponse;
import org.eun.e_blog.post.dto.response.GetUserPostListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag( name = "POST API", description = "게시글 관련 API")
public interface PostController {
    @Operation( summary = "게시글 정보 상세 조회", description = "postID를 통한 게시글 정보 조회")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @GetMapping( "/detail/{postID}")
    ResponseEntity<SuccessResponse<GetPostDetailResponse>> getPostDetail(
            @RequestParam Long postID
    );
    
    @Operation( summary = "게시글 목록 조회", description = "userID를 통한 사용자 게시글 목록 조회")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode =  APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @GetMapping( "/list/{userID}")
    ResponseEntity<SuccessResponse<PageResponse<GetUserPostListResponse>>> getUserPostList(
            @RequestParam Long userID,
            @RequestParam( value = "size", required = false, defaultValue = "10" ) int size,
            @RequestParam( value = "page", required = false, defaultValue = "0" ) int page
    );

    @Operation( summary = "게시글 작성", description = "게시글 작성 API" )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @PostMapping( "/" )
    ResponseEntity<SuccessResponse<Void>> createPost(
        @RequestBody CreatePostRequest createPostRequest
    );
}
