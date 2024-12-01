package org.eun.e_blog.post.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.controller.PostController;
import org.eun.e_blog.post.dto.response.GetPostDetailResponse;
import org.eun.e_blog.post.dto.response.GetUserPostListResponse;
import org.eun.e_blog.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/post")
@RequiredArgsConstructor
public class PostControllerImpl implements PostController {
    private final PostService postService;

    @Override
    public ResponseEntity<SuccessResponse<GetPostDetailResponse>> getPostDetail(Long postID) {
        return null;
    }

    @Override
    public ResponseEntity<SuccessResponse<GetUserPostListResponse>> getUserPostList(Long userID) {
        return null;
    }
}
