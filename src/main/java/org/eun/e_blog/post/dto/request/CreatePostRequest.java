package org.eun.e_blog.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.eun.e_blog.post.entity.PostAccess;
import org.eun.e_blog.post.entity.PostType;

@Schema( name = "Create Post Request", description = "게시글 작성 요청" )
public record CreatePostRequest(
    @Schema( description = "작성자 ID" ) Long userID,
    @Schema( description = "포스트 제목" ) String title,
    @Schema( description = "포스트 내용" ) String content,
    @Schema( description = "포스트 타입" ) PostType postType,
    @Schema( description = "포스트 접근 범위" ) PostAccess postAccess
) {
}
