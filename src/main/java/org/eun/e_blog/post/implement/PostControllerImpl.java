package org.eun.e_blog.post.implement;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.PageResponse;
import org.eun.e_blog.common.dto.response.SuccessResponse;
import org.eun.e_blog.post.controller.PostController;
import org.eun.e_blog.post.dto.request.CreatePostRequest;
import org.eun.e_blog.post.dto.response.GetPostDetailResponse;
import org.eun.e_blog.post.dto.response.GetUserPostListResponse;
import org.eun.e_blog.post.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
        GetPostDetailResponse getPostDetailResponse = postService.getPostDetailResponse(postID);
        return SuccessResponse.of( getPostDetailResponse ).asHttp( HttpStatus.OK );
    }

    @Override
    public ResponseEntity<SuccessResponse<PageResponse<GetUserPostListResponse>>> getUserPostList(Long userID, int size, int page ) {
        PageRequest pageRequest = PageRequest.of( page, size );
        return SuccessResponse.of( postService.getUserPostListResponse( userID, pageRequest ) ).asHttp( HttpStatus.OK );
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> createPost(CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
        return SuccessResponse.ofNoData().asHttp( HttpStatus.OK );
    }
}
