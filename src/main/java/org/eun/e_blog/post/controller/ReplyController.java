package org.eun.e_blog.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eun.e_blog.common.constants.APIResponseMessage;
import org.eun.e_blog.common.dto.response.PageResponse;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.dto.request.CreateReplyRequest;
import org.eun.e_blog.post.dto.response.GetReplyAboutPostResponse;
import org.eun.e_blog.post.entity.Reply;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag( name = "Reply API", description = "댓글 관련 API")
public interface ReplyController {
    @Operation( summary = "댓글 작성 API", description = "댓글 작성 API" )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @PostMapping( "/" )
    ResponseEntity<SuccessResponse<Void>> createReply(
      @RequestBody CreateReplyRequest createReplyRequest
    );

    @Operation( summary = "포스트에 달린 댓글 조회 API", description = "해당 포스트에 달린 댓글 목록 조회 API" )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = APIResponseMessage.SUCCESS_RESPONSE_CODE,
                    description = APIResponseMessage.SUCCESS_RESPONSE_DESCRIPTION
            )
    })
    @GetMapping( "/aboutPost/{postID}")
    ResponseEntity<SuccessResponse<PageResponse<GetReplyAboutPostResponse>>> getReplyByPostID(
        @RequestParam( value = "size", required = false, defaultValue = "20" ) int size,
        @RequestParam( value = "page", required = false, defaultValue = "0" ) int page,
        @RequestParam Long postID
    );
}
