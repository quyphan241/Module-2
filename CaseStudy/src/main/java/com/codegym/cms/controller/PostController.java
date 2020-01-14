package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Post;
import com.codegym.cms.service.CategoryService;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class PostController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PostService postService;
    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView index(Pageable pageable){
        Iterable<Category> categories = categoryService.findAll();
        Page<Post> top4posts = postService.findTop4LatestPost(pageable);
        Iterable<Post> top3View = postService.findTop3MostView();
        Category technology = categoryService.findById((long) 1);
        Category world = categoryService.findById((long) 2);
        Iterable<Post> technologyPosts = postService.findTop3ByCategory(technology);
        Iterable<Post> worldPosts = postService.findTop2ByCategory(world);
        ModelAndView modelAndView = new ModelAndView("/post/index");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("top4posts", top4posts);
        modelAndView.addObject("technologyPosts",technologyPosts);
        modelAndView.addObject("worldPosts", worldPosts);
        modelAndView.addObject("top3View", top3View);
        return modelAndView;
    }

    @GetMapping("/view-post/{id}")
    public ModelAndView viewPost(@PathVariable("id") Long id ) {
        Post post = postService.findById(id);
        if(post==null){
            return new ModelAndView("/error.404");
        }
        post.increment();
        postService.save(post);
        ModelAndView modelAndView= new ModelAndView("/post/single");
        modelAndView.addObject("post", post);
        return modelAndView;
    }
    @GetMapping("/create-post")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView savePost(@ModelAttribute("post") Post post){
        post.setCreateDay(Date.valueOf(LocalDate.now()));
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }
}
