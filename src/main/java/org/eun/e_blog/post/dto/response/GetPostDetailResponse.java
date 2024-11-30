package org.eun.e_blog.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.eun.e_blog.post.entity.Post;
import org.eun.e_blog.post.entity.PostAccess;
import org.eun.e_blog.post.entity.PostType;

@Builder
@Schema( name = "Get Post Detail Response", description = "포스트 상세 정보 조회 응답")
public record GetPostDetailResponse(
        @Schema( description = "포스트 ID" ) Long postID,
        @Schema( description = "작성자 ID" ) Long userID,
        @Schema( description = "포스트 제목" ) String title,
        @Schema( description = "포스트 내용" ) String content,
        @Schema( description = "포스트 형태" ) PostType postType,
        @Schema( description = "포스트 공개 범위") PostAccess postAccess
        ) {
    public static GetPostDetailResponse of( Post post ){
        return GetPostDetailResponse.builder()
                .postID( post.getId() )
                .userID( post.getUserID() )
                .title( post.getTitle() )
                .content( post.getContent() )
                .postType( post.getPostType() )
                .postAccess( post.getPostAccess() )
                .build();
    }
}
