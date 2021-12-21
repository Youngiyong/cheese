package com.cheese.admin.controller.v1;

import com.cheese.core.domain.category.Category;
import com.cheese.core.domain.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/categories")
@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_ADMIN_CUSTOM')")
    @GetMapping
    public List<Category> findAllCategory() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "sort"));
    }

}
