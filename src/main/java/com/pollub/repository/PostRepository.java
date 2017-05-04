package com.pollub.repository;

import com.pollub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Eryk on 2017-05-03.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
