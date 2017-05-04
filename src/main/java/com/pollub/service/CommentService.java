package com.pollub.service;

import com.pollub.model.Comment;
import com.pollub.model.Post;

/**
 * Created by Eryk on 2017-05-04.
 */
public interface CommentService {

    Comment getComment(Long id);

    Comment save(Comment comment, Post post);

    void delete(Comment comment);

}
