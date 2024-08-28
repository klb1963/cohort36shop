package de.ait_tr.g_36_shop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    //cart methods
    // add product to cart
    public void addProduct(Product product) {
        if (product.isActive()) {
            products.add(product);
        }
    }

    // get all active product
    public List<Product> getAllActiveProducts() {
        return products.stream()
                .filter(Product::isActive)
                .toList();
    }

    // remove product by id
    public void removeProductById(Long id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }

    // clear cart
    public void clear() {
        products.clear();
    }

    //
    public BigDecimal getActiveProductsTotalCost() {
        return products.stream()
                .filter(Product::isActive)
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    //
    public BigDecimal getActiveProductsAverageCost() {
        int count = getAllActiveProducts().size();

        if (count == 0) {
            return BigDecimal.ZERO;
        }

        return getActiveProductsTotalCost().divide(new BigDecimal(count), RoundingMode.DOWN);
    }

    // end of specific cart methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        return Objects.equals(id, cart.id) && Objects.equals(customer, cart.customer) && Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, products);
    }

    @Override
    public String toString() {
        return String.format("Cart: id - %d, contains %d products", id, products == null ? 0 : products.size());
    }
}
