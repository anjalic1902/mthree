package com.shopping.repository;

import com.shopping.model.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
    List<ShoppingItem> findByCategory(String category);
}
