package com.example.userssv.repository;

import com.example.userssv.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts-sv")
public interface PostAPiClient {
    @GetMapping(path = "/posts/{userId}")
    List<PostDTO> getPostsByUserId(@PathVariable(name = "userId") int userId);
}
