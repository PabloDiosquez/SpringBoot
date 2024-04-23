package com.example.postsservice.web;

import com.example.postsservice.model.Post;
import com.example.postsservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private PostService postService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable(name = "userId") int userId){
        return new ResponseEntity<>(postService.getPostsByUserId(userId), HttpStatus.OK);
    }
}
