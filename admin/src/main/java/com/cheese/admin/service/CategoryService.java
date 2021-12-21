package com.cheese.admin.service;

import com.cheese.core.domain.admin.Admin;
import com.cheese.core.domain.category.Category;
import com.cheese.core.domain.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "sort"));
    }
}

