package com.blog.siglo21.trabajo.services;

import com.blog.siglo21.trabajo.models.Categoria;
import com.blog.siglo21.trabajo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id).orElseThrow();
        existingCategoria.setNombre(categoria.getNombre());
        return categoriaRepository.save(existingCategoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
