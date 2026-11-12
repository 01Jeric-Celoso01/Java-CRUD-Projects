package org.jcc.data;

import org.jcc.model.Admin;

import java.util.List;

public class AdminSampleData {

    public static List<Admin> getSampleAdmins() {

        Admin admin1 = new Admin("123456789123", "School Administrator");
        Admin admin2 = new Admin("987654321789", "School Registrar");

        return List.of(admin1, admin2);
    }
}