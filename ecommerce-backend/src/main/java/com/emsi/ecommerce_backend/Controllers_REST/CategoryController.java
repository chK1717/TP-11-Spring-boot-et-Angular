package com.emsi.ecommerce_backend.Controllers_REST;
import com.emsi.ecommerce_backend.entities.CategoryEntity;
import com.emsi.ecommerce_backend.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public CategoryEntity get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public CategoryEntity create(@RequestBody CategoryEntity c) {
        return service.create(c);
    }

    @PutMapping("/{id}")
    public CategoryEntity update(@PathVariable Long id, @RequestBody CategoryEntity c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
