package de.ait_tr.g_36_shop.service.interfaces;

import de.ait_tr.g_36_shop.domain.dto.ProductDto;
import de.ait_tr.g_36_shop.domain.entity.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
// меняем Product на ProductDto
    ProductDto save(ProductDto product);
    List<ProductDto> getAllActiveProducts();
    ProductDto getById(Long id);
    ProductDto update(ProductDto product);
    void deleteById(Long id);
    void deleteByTitle(String title);
    void restoreById(Long id);
    long getAllActiveProductsQuantity();
    BigDecimal getAllActiveProductsTotalPrice();
    BigDecimal getAllActiveProductsAveragePrice();
}