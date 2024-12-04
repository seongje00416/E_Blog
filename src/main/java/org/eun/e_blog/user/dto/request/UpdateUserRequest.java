package org.eun.e_blog.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema( name = "Update User Request", description = "유저 정보 수정 요청")
public record UpdateUserRequest(
        @Schema( description = "유저 이름" ) String userName,
        @Schema( description = "유저 별명" ) String nickName,
        @Schema( description = "유저 생일" ) LocalDate birthday
) {}
