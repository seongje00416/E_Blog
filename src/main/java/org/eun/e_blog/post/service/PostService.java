package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.post.dto.request.CreatePostRequest;
import org.eun.e_blog.post.entity.Post;
import org.eun.e_blog.post.repository.PostRepository;
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
}
