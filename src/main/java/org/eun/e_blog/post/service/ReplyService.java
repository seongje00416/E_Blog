package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.PageResponse;
import org.eun.e_blog.post.dto.request.CreateReplyRequest;
import org.eun.e_blog.post.dto.response.GetReplyAboutPostResponse;
import org.eun.e_blog.post.entity.Reply;
import org.eun.e_blog.post.repository.ReplyRepository;
import org.eun.e_blog.util.PageUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void createReply(CreateReplyRequest createReplyRequest) {
        Reply reply = Reply.builder()
                .postID( createReplyRequest.postID() )
                .userID( createReplyRequest.userID() )
                .comment(createReplyRequest.comment() )
                .build();
        replyRepository.save(reply);
    }

    public PageResponse<GetReplyAboutPostResponse> getReplyAboutPost( PageRequest pageRequest, Long postID ) {
        return PageUtils.toPageResponse( replyRepository.findAllByPostIDAndDeletedAtIsNull( postID, pageRequest ) )
                .map(GetReplyAboutPostResponse::of);
    }
}
