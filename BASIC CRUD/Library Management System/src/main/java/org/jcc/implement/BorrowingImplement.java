package org.jcc.implement;

import org.jcc.data.BorrowingData;
import org.jcc.model.BorrowingModel;
import org.jcc.repository.BorrowingRepository;

import java.util.ArrayList;
import java.util.List;

public class BorrowingImplement implements BorrowingRepository {

    private final List<BorrowingModel> BORROWING =
            new ArrayList<>(BorrowingData.sampleBorrowing());

    @Override
    public BorrowingModel save(BorrowingModel borrowing) {

        if (borrowing == null) {
            return null;
        }

        BORROWING.add(borrowing);

        return borrowing;
    }

    @Override
    public List<BorrowingModel> findAll() {
        return new ArrayList<>(BORROWING);
    }

    @Override
    public BorrowingModel findById(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }

        for (BorrowingModel borrowing : BORROWING) {

            if (borrowing.getId().equalsIgnoreCase(id)) {
                return borrowing;
            }
        }

        return null;
    }

    @Override
    public BorrowingModel updateById(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        for (BorrowingModel bg : BORROWING) {
            if (bg.getId().equals(id)) {
                return bg;
            }
        }
        return null;
    }
}