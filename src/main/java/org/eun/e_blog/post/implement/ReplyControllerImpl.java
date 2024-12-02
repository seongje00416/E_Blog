package org.eun.e_blog.post.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.controller.ReplyController;
import org.eun.e_blog.post.dto.request.CreateReplyRequest;
import org.eun.e_blog.post.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/reply" )
@RequiredArgsConstructor
public class ReplyControllerImpl implements ReplyController {
    private final ReplyService replyService;

    @Override
    public ResponseEntity<SuccessResponse<Void>> createReply(CreateReplyRequest createReplyRequest) {
        replyService.createReply(createReplyRequest);
        return SuccessResponse.ofNoData().asHttp( HttpStatus.OK );
    }
}
