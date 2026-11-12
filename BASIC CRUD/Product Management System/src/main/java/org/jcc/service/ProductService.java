package org.jcc.service;

import org.jcc.implement.ProductImplement;
import org.jcc.model.Product;

import java.util.List;

public class ProductService {

    private final ProductImplement IMPLEMENT;

    public ProductService(ProductImplement implement) {
        this.IMPLEMENT = implement;
    }

    public Boolean register(Product product) {
        return IMPLEMENT.create(product);
    }

    public List<Product> view() {
        return IMPLEMENT.read();
    }

    public Product update(String id) {
        return IMPLEMENT.update(id);
    }

    public Product delete(String id) { return IMPLEMENT.delete(id); }

    public Product search(String id) { return IMPLEMENT.search(id); }
}
