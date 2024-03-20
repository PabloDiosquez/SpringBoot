package com.example.postssv.web;

import com.example.postssv.model.Post;
import com.example.postssv.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping(path = "/{userId}")
    public List<Post> getPostsByUserId(@PathVariable(name = "userId") int userId){
        System.out.println("Port = " + serverPort);
        return postService.getPostsByUserId(userId);
    }
}
