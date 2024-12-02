package org.eun.e_blog.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.eun.e_blog.post.entity.PostAccess;
import org.eun.e_blog.post.entity.PostType;

@Schema( name = "Create Post Request", description = "게시글 작성 요청" )
public record CreatePostRequest(
    @Schema( description = "작성자 ID", requiredMode = Schema.RequiredMode.REQUIRED )
    @NotNull( message = "작성자 정보는 필수입니다." )
    Long userID,
    @Schema( description = "포스트 제목", requiredMode = Schema.RequiredMode.REQUIRED, example = "제목 없음" )
    String title,
    @Schema( description = "포스트 내용", requiredMode = Schema.RequiredMode.REQUIRED )
    @NotNull( message = "내용을 입력하세요." )
    String content,
    @Schema( description = "포스트 타입", requiredMode = Schema.RequiredMode.REQUIRED, implementation = PostType.class )
    @NotNull
    PostType postType,
    @Schema( description = "포스트 접근 범위", requiredMode = Schema.RequiredMode.REQUIRED, implementation = PostAccess.class )
    @NotNull
    PostAccess postAccess
) {
}
