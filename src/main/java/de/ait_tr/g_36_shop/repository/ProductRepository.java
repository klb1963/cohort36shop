package de.ait_tr.g_36_shop.repository;

import de.ait_tr.g_36_shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
