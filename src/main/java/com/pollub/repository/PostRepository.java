package com.pollub.repository;

import com.pollub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eryk on 2017-05-03.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

}
