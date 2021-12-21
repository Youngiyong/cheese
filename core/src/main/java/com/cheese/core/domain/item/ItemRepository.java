package com.cheese.core.domain.category;

import com.cheese.core.domain.storeGroup.StoreGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
