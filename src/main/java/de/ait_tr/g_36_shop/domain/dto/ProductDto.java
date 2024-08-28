package de.ait_tr.g_36_shop.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Schema(description = "Class that describes Product") // add for Swagger
public class ProductDto {

    @Schema( // add for Swagger
            description = "Product unique identifier",
            example = "111",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(description = "Product title", example = "banana") // add for Swagger
    private String title;

    @Schema(description = "Product price", example = "190.00") // add for Swagger
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price);
    }

    @Override
    public String toString() {
        return String.format("Product DTO: id - %d, title - %s, price - %s, active - %s",
                id, title, price);
    }
}