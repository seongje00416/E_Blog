package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.common.dto.response.PageResponse;
import org.eun.e_blog.post.dto.request.CreatePostRequest;
import org.eun.e_blog.post.dto.response.GetPostDetailResponse;
import org.eun.e_blog.post.dto.response.GetUserPostListResponse;
import org.eun.e_blog.post.entity.Post;
import org.eun.e_blog.post.exception.PostNotFoundException;
import org.eun.e_blog.post.repository.PostRepository;
import org.eun.e_blog.util.PageUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void createPost( CreatePostRequest createPostRequest ) {
        Post post = Post.builder()
                .userID(createPostRequest.userID() )
                .postType( createPostRequest.postType() )
                .postAccess( createPostRequest.postAccess() )
                .title( createPostRequest.title() )
                .content( createPostRequest.content() )
                .build();
        postRepository.save( post );
    }

    public GetPostDetailResponse getPostDetailResponse( Long postID ) {
        Post post = postRepository.findByIdAndDeletedAtIsNull( postID ).orElseThrow(PostNotFoundException::new);
        return GetPostDetailResponse.of( post );
    }

    public PageResponse<GetUserPostListResponse> getUserPostListResponse( Long userID, PageRequest pageRequest ) {
        return PageUtils.toPageResponse( postRepository.findAllByUserIDAndDeletedAtIsNull( userID, pageRequest ) )
                .map(GetUserPostListResponse::of);
    }
}
