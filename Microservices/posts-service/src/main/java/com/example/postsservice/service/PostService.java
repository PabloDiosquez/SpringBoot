package com.example.postsservice.service;

import com.example.postsservice.model.Post;
import java.util.List;

public interface PostService {

    List<Post> getPostsByUserId(int userId);
}
