package org.jcc.service;

import org.jcc.implement.BorrowerImplementation;
import org.jcc.model.BorrowerModel;

import java.util.List;

public class BorrowerService {

    BorrowerImplementation implement = new BorrowerImplementation();

    public BorrowerService(BorrowerImplementation implement) {
        this.implement = implement;
    }

    public BorrowerModel registerBorrower(BorrowerModel borrower) {
        implement.create(borrower);
        return borrower;
    }

    public List<BorrowerModel> viewAll() {
        return implement.view();
    }

    public BorrowerModel searchById(String id) {
        return implement.search(id);
    }

    public BorrowerModel updateById(String id) {
        return implement.update(id);
    }

    public BorrowerModel deleteById(String id) {
        return implement.delete(id);
    }
}
