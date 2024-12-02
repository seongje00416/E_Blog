package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.post.dto.request.CreateReplyRequest;
import org.eun.e_blog.post.entity.Reply;
import org.eun.e_blog.post.repository.ReplyRepository;
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
}
