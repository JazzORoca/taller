package com.blog.siglo21.trabajo.repository;

import com.blog.siglo21.trabajo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
