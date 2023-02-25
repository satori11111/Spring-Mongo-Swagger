package com.mongo.springmongo.controllers;


import com.mongo.springmongo.model.Post;
import com.mongo.springmongo.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

@RestController
@ComponentScan(basePackages = "com.mongo.springmongo.repository")
public class PostController {
    @Autowired
     PostRepo postRepo;
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response){
        try {
            response.sendRedirect("/swagger-ui.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
       return postRepo.findAll();

    }
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
       return postRepo.save(post);
    }


}
