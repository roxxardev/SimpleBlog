package com.pollub.service;

import com.pollub.model.Post;
import org.springframework.data.domain.Page;

/**
 * Created by Eryk on 2017-05-04.
 */
public interface PostService {

    Page<Post> getPosts(int page, int size);

    Post getPost(Long id);

    Post save(Post post);

    void delete(Post post);

}
