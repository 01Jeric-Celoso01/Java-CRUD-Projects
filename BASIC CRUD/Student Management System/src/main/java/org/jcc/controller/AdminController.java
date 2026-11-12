
package org.jcc.controller;

import org.jcc.model.Admin;
import org.jcc.enums.AccountRole;

import java.util.List;

public class AdminController {

    private final List<Admin> admins;

    public AdminController(List<Admin> admins) {
        this.admins = admins;
    }

    // LOGIN ADMIN WITH ID AND ROLE
    public Admin loginAdmin(String adminId, AccountRole role) {

        for (Admin admin : admins) {

            if (admin.getAdminId().equals(adminId) && admin.getRole() == role) {

                return admin;
            }
        }

        return null;
    }
}
