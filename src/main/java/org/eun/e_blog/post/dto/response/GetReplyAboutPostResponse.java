package org.eun.e_blog.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.eun.e_blog.post.entity.Reply;

import java.time.LocalDateTime;

@Builder
@Schema( name = "Get Reply in Post", description = "포스트에 달린 댓글들의 목록 응답" )
public record GetReplyAboutPostResponse(
        @Schema( description = "댓글 ID" ) Long replyID,
        @Schema( description = "작성자 ID" ) Long userID,
        @Schema( description = "댓글 내용" ) String comment,
        @Schema( description = "작성 날짜" ) LocalDateTime createdAt
        ) {
    public static GetReplyAboutPostResponse of( Reply reply ){
        return GetReplyAboutPostResponse.builder()
                .replyID( reply.getId() )
                .userID( reply.getUserID() )
                .comment( reply.getComment() )
                .createdAt( reply.getCreatedAt() )
                .build();
    }
}
