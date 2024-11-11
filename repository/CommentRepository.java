package com.blog.siglo21.trabajo.repository;


import com.blog.siglo21.trabajo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
