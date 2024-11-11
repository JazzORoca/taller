package com.blog.siglo21.trabajo.services;

import com.blog.siglo21.trabajo.models.Comment;
import com.blog.siglo21.trabajo.models.Post;
import com.blog.siglo21.trabajo.repository.CommentRepository;
import com.blog.siglo21.trabajo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        post.setDate(new Date());
        return postRepository.save(post);
    }

    public Comment addComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setDate(new Date());
        comment.setPost(post);
        return commentRepository.save(comment);
    }
}
