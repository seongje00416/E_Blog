package org.eun.e_blog.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.eun.e_blog.post.entity.PostType;
import org.eun.e_blog.user.entity.Gender;

@Schema( name = "Create User Account Request", description = "회원가입을 위한 요청" )
public record CreateUserAccountRequest(
        @Schema( description = "이메일", requiredMode = Schema.RequiredMode.REQUIRED ) String email,
        @Schema( description = "비밀번호", requiredMode = Schema.RequiredMode.REQUIRED ) String password,
        @Schema( description = "이름", requiredMode = Schema.RequiredMode.REQUIRED ) String name,
        @Schema( description = "닉네임" ) String nickName,
        @Schema( description = "생년월일", requiredMode = Schema.RequiredMode.REQUIRED) String birthday,
        @Schema( description = "성별", implementation = Gender.class ) Gender gender
) {}
