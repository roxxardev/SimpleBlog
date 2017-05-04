package com.pollub.service;

import com.pollub.model.Post;
import com.pollub.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Eryk on 2017-05-04.
 */

@Service("postService")
public class DefaultPostService implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Override
    public Page<Post> getPosts(int page, int size) {
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.DESC, "commentDate");
        return postRepository.findAll(pageRequest);
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post save(Post post) {
        post.setPostDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
