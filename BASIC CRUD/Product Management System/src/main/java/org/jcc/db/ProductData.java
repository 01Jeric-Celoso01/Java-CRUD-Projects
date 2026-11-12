package org.jcc.db;

import org.jcc.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductData {
    static List<Product> pt = new ArrayList<>();

    public static List<Product> sample() {
        Product p1 = new Product("PRD-001", "Logitech Wireless Mouse", "Wireless optical mouse with USB reveiver", "ELECTRONICS", "LOGITECH", 850, 50, "LOG-MOUE-001", "4801234567890", "Tech Supplies PH", LocalDate.of(2026, 11, 10), LocalDate.of(2029, 11, 10), "ACTIVE");
        pt.add(p1);

        return pt;
    }
}
