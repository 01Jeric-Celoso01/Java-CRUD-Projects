package org.jcc.repository;

import org.jcc.model.BorrowerModel;

import java.util.List;

public interface BorrowerRepository {
    BorrowerModel create(BorrowerModel borrower);
    List<BorrowerModel> view();
    BorrowerModel search(String id);
    BorrowerModel update(String id);
    BorrowerModel delete(String id);
}
