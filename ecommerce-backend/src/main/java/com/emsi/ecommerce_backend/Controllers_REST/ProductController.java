package com.emsi.ecommerce_backend.Controllers_REST;
import com.emsi.ecommerce_backend.entities.ProductEntity;
import com.emsi.ecommerce_backend.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ProductEntity get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/category/{id}")
    public List listByCategory(@PathVariable Long id) {
        return service.listByCategory(id);
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity p) {
        return service.create(p);
    }

    @PutMapping("/{id}")
    public ProductEntity update(@PathVariable Long id, @RequestBody ProductEntity p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
