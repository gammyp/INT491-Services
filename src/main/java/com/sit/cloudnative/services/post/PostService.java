package com.sit.cloudnative.services.post;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public List<UserPost> getAllPosts() {
        return postRepository.findAll();
    }
    
    public UserPost getPostById(long id) {
        Optional<UserPost> post = postRepository.findById(id);
        return post.get();
    }
    
    public UserPost createPost(UserPost post) {
        return postRepository.save(post);
    }
}
