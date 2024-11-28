package org.eun.e_blog.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.eun.e_blog.user.entity.User;

@Builder
@Schema( name="User Detail Response", description="사용자 상제 정보 조회 응답")
public record GetUserDetailResponse (
        @Schema( description="사용자 ID") Long userID,
        @Schema( description="사용자 이름") String name
){
    public static GetUserDetailResponse of(User user) {
        return GetUserDetailResponse.builder()
                .userID( user.getId() )
                .name( user.getUserName() )
                .build();
    }
}
