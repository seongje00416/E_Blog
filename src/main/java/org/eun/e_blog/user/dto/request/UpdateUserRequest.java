package org.eun.e_blog.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema( name = "Update User Request", description = "유저 정보 수정 요청")
public record UpdateUserRequest(
        @Schema( description = "유저 이름", requiredMode = Schema.RequiredMode.REQUIRED ) String userName
) {}
