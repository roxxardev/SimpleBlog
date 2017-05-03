package com.pollub.repository;

import com.pollub.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eryk on 2017-05-03.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
