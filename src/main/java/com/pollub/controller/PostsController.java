package com.pollub.controller;

import com.pollub.model.Comment;
import com.pollub.model.Post;
import com.pollub.service.CommentService;
import com.pollub.service.PostService;
import com.pollub.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by Eryk on 2017-05-07.
 */
@Controller
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    Logger logger = LoggerFactory.getLogger(PostsController.class);

    @RequestMapping(value = {"/", "/posts"}, method = RequestMethod.GET)
    public String showPostList(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "5") int size, Model model) {

        Post tempPost = new Post();
        tempPost.setTitle("Dupa");
        tempPost.setTease("Dupa dsfjfjlkdlfdsjfsd ljsdjlf fsljd ljksfdljk fsljf ldjjlfd slf dsl sdf");
        tempPost.setPostText("dsakjdassjsjljlljajdjfdsklfjldsjflkjfkjsdljfjsdlkfjskgjdsgkjdslkdsjflskdjflksdjflsjflskjflskdfjsdklfjskljffjdljsfjslfs");
        tempPost.setAuthor(userService.findLoggedInUser());
        tempPost.setPostDate(LocalDateTime.now());
        postService.save(tempPost);

        Page<Post> posts = postService.getPosts(page, size);
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "post";
    }

    @RequestMapping(value = "/posts/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        postService.delete(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.POST)
    public String createComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment) {
        Post post = postService.getPost(id);
        comment.setCommentDate(LocalDateTime.now());
        comment.setUser(userService.findLoggedInUser());
        comment.setPost(post);
        commentService.save(comment,post);

        logger.info("comment id = " + comment.getId());
        return "redirect:/posts/{id}";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String createPost(Model model) {
        model.addAttribute("post", new Post());

        return "createPost";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "createPost";
        }

        post.setPostDate(LocalDateTime.now());
        post.setAuthor(userService.findLoggedInUser());
        postService.save(post);
        return "redirect:/posts";
    }
}
