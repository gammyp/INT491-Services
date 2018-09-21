package com.sit.cloudnative.services.comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    
    @Autowired
    CommentRepository commentRepository;
    
    public List<Comment> getCommentByPost(long postId) {
        return commentRepository.findByPostId(postId);
    }
    
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
