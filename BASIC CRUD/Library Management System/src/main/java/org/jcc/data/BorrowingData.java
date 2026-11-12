package org.jcc.data;

import org.jcc.model.BorrowingModel;
import org.jcc.util.GenerateId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowingData {

    public static List<BorrowingModel> sampleBorrowing() {

        List<BorrowingModel> borrowing = new ArrayList<>();

        BorrowingModel bm1 = new BorrowingModel(GenerateId.generateBorrowingId(), "BK00000001", "BR00000001", 1, LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 7));
        borrowing.add(bm1);

        BorrowingModel bm2 = new BorrowingModel(GenerateId.generateBorrowingId(), "BK00000002", "BR00000002", 1, LocalDate.of(2026, 11, 2), LocalDate.of(2026, 11, 4));
        borrowing.add(bm2);

        BorrowingModel bm3 = new BorrowingModel(GenerateId.generateBorrowingId(), "BK00000001", "BR00000001", 1, LocalDate.of(2026, 11, 7), LocalDate.of(2026, 11, 11));
        borrowing.add(bm3);


        return borrowing;
    }
}