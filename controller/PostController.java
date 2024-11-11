package com.blog.siglo21.trabajo.controller;



import com.blog.siglo21.trabajo.models.Comment;
import com.blog.siglo21.trabajo.models.Post;

import com.blog.siglo21.trabajo.services.PostService;

import org.springframework.web.bind.annotation.*;
import java.util.List;





@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PostMapping("/{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return postService.addComment(postId, comment);
    }
}
