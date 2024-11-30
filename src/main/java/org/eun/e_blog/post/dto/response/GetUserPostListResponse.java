package org.eun.e_blog.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.eun.e_blog.post.entity.Post;

@Builder
@Schema( name = "User Post List Response", description = "userID를 통한 해당 사용자의 포스트 조회 응답")
public record GetUserPostListResponse(
        @Schema( description = "포스트 ID" ) Long postID,
        @Schema( description = "포스트 제목" ) String title,
        @Schema( description = "포스트 내용" ) String content
) {
    public static GetUserPostListResponse of( Post post ){
        return GetUserPostListResponse.builder()
                .postID( post.getId() )
                .title( post.getTitle() )
                .content( post.getContent() )
                .build();
    }

}
