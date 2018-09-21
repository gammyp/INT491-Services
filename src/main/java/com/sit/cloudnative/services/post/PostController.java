package com.sit.cloudnative.services.post;

import com.sit.cloudnative.services.comment.CommentService;
import com.sit.cloudnative.services.user.UserService;
import java.util.List;
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
public class PostController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    PostService postService;
    
    @Autowired
    CommentService commentService;
    
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<UserPost>> getPosts() {
        List<UserPost> posts = postService.getAllPosts();
        return new ResponseEntity<List<UserPost>>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/post/user/{userId}", method = RequestMethod.POST)
    public ResponseEntity<UserPost> createPost(
        @PathVariable (value = "userId") Long userId,
        @Valid @RequestBody UserPost post
    ) {
        post.setUser(userService.getUserById(userId));
        UserPost post_object = postService.createPost(post);
        return new ResponseEntity<UserPost>(post_object, HttpStatus.OK);
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public ResponseEntity<UserPost> getPost(@PathVariable(name = "post_id") int id) {
        UserPost post = postService.getPostById(id);
        return new ResponseEntity<UserPost>(post, HttpStatus.OK);
    }
}
