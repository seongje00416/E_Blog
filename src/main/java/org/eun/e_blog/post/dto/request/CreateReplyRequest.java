package org.eun.e_blog.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema( name = "Create Reply Request", description = "댓글 등록 요청" )
public record CreateReplyRequest(
        @Schema( description = "작성자 ID", requiredMode = Schema.RequiredMode.REQUIRED ) Long userID,
        @Schema( description = "포스트 ID", requiredMode = Schema.RequiredMode.REQUIRED ) Long postID,
        @Schema( description = "댓글 내용", requiredMode = Schema.RequiredMode.REQUIRED ) String comment
) {
}
