package com.example.usersservice.repository;

import com.example.usersservice.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts-service")
public interface PostApiClient {

    @GetMapping(path = "/posts/{userId}")
    List<PostDTO> getPostsByUserId(@PathVariable(name = "userId") int userId);
}
