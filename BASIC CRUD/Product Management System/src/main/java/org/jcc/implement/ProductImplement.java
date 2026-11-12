package org.jcc.implement;

import org.jcc.db.ProductData;
import org.jcc.model.Product;
import org.jcc.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductImplement implements ProductRepository {

    private final List<Product> P = new ArrayList<>(ProductData.sample());


    @Override
    public Boolean create(Product product) {
        if (product != null) {
            P.add(product);
            return true;
        }

        return false;
    }


    @Override
    public List<Product> read() {
        return P;
    }


    @Override
    public Product update(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        for (Product product : P) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }


    @Override
    public Product delete(String id) {
        Iterator<Product> iterate = P.iterator();

        while (iterate.hasNext()) {
            Product product = iterate.next();

            if (product.getId().equals(id)) {
                iterate.remove();
                return product;
            }
        }

        return null;
    }

    @Override
    public Product search(String id) {
        if (id != null) {
            for (Product product : P) {
                if (product.getId().equals(id)) {
                    return product;
                }
            }
        }

        return null;
    }
}
