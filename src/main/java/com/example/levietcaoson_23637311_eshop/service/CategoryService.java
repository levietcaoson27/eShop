package com.example.levietcaoson_23637311_eshop.service;


import com.example.levietcaoson_23637311_eshop.entity.Category;
import com.example.levietcaoson_23637311_eshop.exception.NotFoundException;
import com.example.levietcaoson_23637311_eshop.repository.CategoryRepository;
import com.example.levietcaoson_23637311_eshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public List<Category> findAll() {
        return categoryRepository.findAllByOrderByNameAsc();
    }
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy danh mục id = " + id));
    }
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    public void delete(Long id) {
        if (productRepository.existsByCategoryId(id)) {
            throw new IllegalStateException("Danh mục đang có sản phẩm, không thể xoá");
        }
        categoryRepository.deleteById(id);
    }
}
