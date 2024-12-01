package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
}
