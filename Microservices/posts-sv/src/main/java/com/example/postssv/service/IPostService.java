package com.example.postssv.service;

import com.example.postssv.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> getPostsByUserId(int userId);
}
