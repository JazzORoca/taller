package com.blog.siglo21.trabajo.repository;


import com.blog.siglo21.trabajo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
