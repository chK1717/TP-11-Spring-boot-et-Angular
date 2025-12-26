package com.emsi.ecommerce_backend.Services;

import com.emsi.ecommerce_backend.entities.CategoryEntity;
import com.emsi.ecommerce_backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryEntity create(CategoryEntity c) {
        return repository.save(c);
    }

    public CategoryEntity update(Long id, CategoryEntity c) {
        c.setId(id);
        return repository.save(c);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CategoryEntity get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List list() {
        return repository.findAll();
    }
}
