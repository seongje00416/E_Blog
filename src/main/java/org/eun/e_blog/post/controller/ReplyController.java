package org.eun.e_blog.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.eun.e_blog.common.constants.APIResponseMessage;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.dto.request.CreateReplyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag( name = "Reply API", description = "댓글 관련 API")
public interface ReplyController {
    @Operation( summary = "Create Reply API", description = "댓글 작성 API" )
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
}
