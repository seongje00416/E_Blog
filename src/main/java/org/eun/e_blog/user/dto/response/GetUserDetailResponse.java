package org.eun.e_blog.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema( name="User Detail Response", description="사용자 상제 정보 조회 응답")
public record GetUserDetailResponse (
        @Schema( description="사용자 ID") Long userID

){

}
