package com.pollub.controller;

import com.pollub.model.Comment;
import com.pollub.model.Post;
import com.pollub.service.CommentService;
import com.pollub.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Eryk on 2017-05-07.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts/{id}/comments", method = RequestMethod.GET)
    public String showComments(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);

        List<Comment> comments = post.getComments();

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());

        return "comments";
    }

    @RequestMapping(value = "/posts/{id}/comments", method = RequestMethod.POST)
    public String addComment(@PathVariable("id") Long id,@ModelAttribute("comment") Comment comment) {
        Post post = postService.getPost(id);
        commentService.save(comment, post);

        return "comments";
    }
}
