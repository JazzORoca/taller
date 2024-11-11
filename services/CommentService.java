package com.blog.siglo21.trabajo.services;

import com.blog.siglo21.trabajo.models.Comment;
import com.blog.siglo21.trabajo.models.Post;
import com.blog.siglo21.trabajo.repository.CommentRepository;
import com.blog.siglo21.trabajo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment addComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);
        return commentRepository.save(comment);
    }
}
