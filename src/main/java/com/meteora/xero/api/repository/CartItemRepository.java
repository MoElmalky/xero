package com.meteora.xero.api.repository;

import com.meteora.xero.api.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    @Query("SELECT c FROM CartItem c WHERE c.user.id = :userId")
    List<CartItem> getUserCart(@Param("userId") Long userId);
}
