package org.jcc.repository;

import org.jcc.model.BorrowingModel;

import java.util.List;

public interface BorrowingRepository {
    BorrowingModel save(BorrowingModel borrowing);
    List<BorrowingModel> findAll();
    BorrowingModel findById(String id);
    BorrowingModel updateById(String id);
}