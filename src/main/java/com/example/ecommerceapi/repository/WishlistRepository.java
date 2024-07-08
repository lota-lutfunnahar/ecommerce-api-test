package com.example.ecommerceapi.repository;
import com.example.ecommerceapi.model.Item;
import com.example.ecommerceapi.model.Wishlist;
import com.example.ecommerceapi.model.WishlistId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, WishlistId>{
    @Query("SELECT i FROM Item i JOIN Wishlist w ON i.id = w.itemId WHERE w.customerId = :customerId")
    List<Item> findItemsByCustomerId(@Param("customerId") Long customerId);
}
