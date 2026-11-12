package org.jcc.implement;

import org.jcc.data.SampleBorrower;
import org.jcc.model.BorrowerModel;
import org.jcc.repository.BorrowerRepository;
import org.jcc.ui.Design;

import java.util.ArrayList;
import java.util.List;

public class BorrowerImplementation implements BorrowerRepository {
    private final List<BorrowerModel> BORROWERS = new ArrayList<>(SampleBorrower.sampleBorrower());

    @Override
    public BorrowerModel create(BorrowerModel borrower) {
        BORROWERS.add(borrower);
        return borrower;
    }

    @Override
    public List<BorrowerModel> view() {
        return BORROWERS;
    }

    @Override
    public BorrowerModel search(String id) {
        if (id == null) {
            return null;
        }

        for (BorrowerModel br : BORROWERS) {
            if (br.getId().equals(id)) {
                return br;
            }
        }

        return null;
    }

    @Override
    public BorrowerModel update(String id) {
        if (id == null) {
            Design.status("ACCOUNT ID NOT FOUND");
        }

        for (BorrowerModel br : BORROWERS) {
            if (br.getId().equals(id)) {
                return br;
            }
        }

        return null;
    }

    @Override
    public BorrowerModel delete(String id) {
        if (id == null) {
            Design.status("ACCOUNT ID NOT FOUND");
        }

        for (BorrowerModel br : BORROWERS) {
            if (br.getId().equals(id)) {
                BORROWERS.remove(br);
                return br;
            }
        }

        return null;
    }
}
