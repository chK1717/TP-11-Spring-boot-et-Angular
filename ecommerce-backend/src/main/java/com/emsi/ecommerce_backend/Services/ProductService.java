package com.emsi.ecommerce_backend.Services;
import com.emsi.ecommerce_backend.entities.ProductEntity;
import com.emsi.ecommerce_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductEntity create(ProductEntity p) {
        return repository.save(p);
    }

    public ProductEntity update(Long id, ProductEntity p) {
        p.setId(id);
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ProductEntity get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List list() {
        return repository.findAll();
    }

    public List listByCategory(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }
}