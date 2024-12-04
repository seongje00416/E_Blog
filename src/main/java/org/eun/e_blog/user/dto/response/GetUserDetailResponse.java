package org.eun.e_blog.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.eun.e_blog.user.entity.Gender;
import org.eun.e_blog.user.entity.User;

import java.time.LocalDate;

@Builder
@Schema( name="User Detail Response", description="사용자 상제 정보 조회 응답")
public record GetUserDetailResponse (
        @Schema( description="사용자 ID") Long userID,
        @Schema( description="사용자 이름") String name,
        @Schema( description="사용자 별명" ) String nickName,
        @Schema( description="사용자 생일" ) LocalDate birthday,
        @Schema( description="사용자 성별" ) Gender gender
){
    public static GetUserDetailResponse of(User user) {
        return GetUserDetailResponse.builder()
                .userID( user.getId() )
                .name( user.getUserName() )
                .nickName( user.getNickName() )
                .birthday( user.getBirthday() )
                .gender( user.getGender() )
                .build();
    }
}
