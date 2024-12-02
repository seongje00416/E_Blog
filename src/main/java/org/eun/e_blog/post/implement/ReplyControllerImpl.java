package org.eun.e_blog.post.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.PageResponse;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.controller.ReplyController;
import org.eun.e_blog.post.dto.request.CreateReplyRequest;
import org.eun.e_blog.post.dto.response.GetReplyAboutPostResponse;
import org.eun.e_blog.post.entity.Reply;
import org.eun.e_blog.post.service.ReplyService;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public ResponseEntity<SuccessResponse<PageResponse<GetReplyAboutPostResponse>>> getReplyByPostID(int size, int page, Long postID) {
        PageRequest pageRequest = PageRequest.of( page, size );
        return SuccessResponse.of( replyService.getReplyAboutPost( pageRequest, postID ) ).asHttp( HttpStatus.OK );
    }
}
