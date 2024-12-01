package org.eun.e_blog.post.service;

import lombok.RequiredArgsConstructor;
import org.eun.e_blog.post.repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
}
