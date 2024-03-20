package com.example.postssv.service;

import com.example.postssv.model.Post;
import com.example.postssv.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Post> getPostsByUserId(int userId) {
        return postRepository.findPostsByUserId(userId);
    }
}
