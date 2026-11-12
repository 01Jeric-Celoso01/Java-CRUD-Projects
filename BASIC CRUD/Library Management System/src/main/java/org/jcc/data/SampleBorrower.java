package org.jcc.data;

import org.jcc.model.BorrowerModel;
import org.jcc.util.GenerateId;

import java.util.ArrayList;
import java.util.List;

public class SampleBorrower {
    public static List<BorrowerModel> sampleBorrower() {
        List<BorrowerModel> borrower = new ArrayList<>();

        BorrowerModel br1 = new BorrowerModel(GenerateId.generateBorrowerId(), "Juan", "D", "Cruz", "Male", "09456321789", "juan@gmail.com", "New Manila");
        borrower.add(br1);

        BorrowerModel br2 = new BorrowerModel(GenerateId.generateBorrowerId(), "Jhon", "A", "Doe", "Male", "09258789321", "jhon@gmail.com", "Quezon City");
        borrower.add(br2);

        return borrower;
    }
}
