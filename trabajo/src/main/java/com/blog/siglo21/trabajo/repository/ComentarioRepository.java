package com.blog.siglo21.trabajo.repository;


import com.blog.siglo21.trabajo.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
