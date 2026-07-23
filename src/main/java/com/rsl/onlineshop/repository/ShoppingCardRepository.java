package com.rsl.onlineshop.repository;

import com.rsl.onlineshop.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Long> {
}
