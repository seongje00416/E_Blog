package org.eun.e_blog.common.dto.response;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SuccessResponse<T> {

    private final boolean success = true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> SuccessResponse<T> of(T data) {
        SuccessResponse<T> successResponse = new SuccessResponse<>();

        successResponse.data = data;

        return successResponse;
    }

    public static SuccessResponse<Void> ofNoData() {
        return new SuccessResponse<>();
    }

    public ResponseEntity<SuccessResponse<T>> asHttp(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(this);
    }

    public ResponseEntity<SuccessResponse<T>> okWithCookie(ResponseCookie responseCookie) {
        return ResponseEntity.ok()
                .header(SET_COOKIE, responseCookie.toString())
                .body(this);
    }

}