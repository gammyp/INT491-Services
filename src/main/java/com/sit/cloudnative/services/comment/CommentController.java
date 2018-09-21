package com.sit.cloudnative.services.comment;

import com.sit.cloudnative.services.post.PostService;
import com.sit.cloudnative.services.user.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
    @Autowired
    PostService postService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping(
            value = "/comment/user/{userId}/post/{postId}",
            method = RequestMethod.POST
    )
    public ResponseEntity<Comment> create(
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "postId") Long postId,
            @Valid @RequestBody Comment comment
    ) {
        comment.setUser(userService.getUserById(userId));
        comment.setPost(postService.getPostById(postId));
        Comment comment_object = commentService.createComment(comment);
        return new ResponseEntity<Comment>(comment_object, HttpStatus.OK);
  }
}
