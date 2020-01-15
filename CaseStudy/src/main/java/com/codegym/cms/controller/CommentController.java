package com.codegym.cms.controller;

import com.codegym.cms.model.Comment;
import com.codegym.cms.model.Post;
import com.codegym.cms.service.CommentService;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    PostService postService;
    @PostMapping("/save-comment")
    public String saveCustomer(@ModelAttribute("comment") Comment comment, @RequestParam("post_id")Long postId){
        Post post = postService.findById(postId);
        comment.setPost(post);
        commentService.save(comment);
        return "redirect:/view-post/"+postId;
    }
}
