package org.jcc.repository;

import org.jcc.model.Product;

import java.util.List;

public interface ProductRepository {
    Boolean create(Product product);
    List<Product> read();
    Product update(String id);
    Product delete(String id);

    Product search(String id);
}
