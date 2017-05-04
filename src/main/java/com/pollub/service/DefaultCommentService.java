package com.pollub.service;

import com.pollub.model.Comment;
import com.pollub.model.Post;
import com.pollub.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Eryk on 2017-05-04.
 */

@Service("commentService")
public class DefaultCommentService implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment save(Comment comment, Post post) {
        comment.setCommentDate(LocalDateTime.now());
        comment.setPost(post);
        comment.setUser(userService.findLoggedInUser());
        commentRepository.save(comment);
        return null;
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
