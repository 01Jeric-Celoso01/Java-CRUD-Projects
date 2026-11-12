package org.jcc.controllers;

import org.jcc.enums.Category;
import org.jcc.enums.Gender;
import org.jcc.implement.ContactImplement;
import org.jcc.model.Contact;
import org.jcc.service.ContactService;
import org.jcc.ui.Design;
import org.jcc.util.BirthDay;
import org.jcc.util.GenerateAge;
import org.jcc.util.GenerateDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ContactController {
    private final Scanner input;

    public ContactController(Scanner input) {
        this.input = input;
    }

    ContactImplement contactImp = new ContactImplement();
    ContactService contactService = new ContactService(contactImp);

    public void registerController() {
        System.out.print("||| CONTACT FIRST NAME    : ");
        String firstName = input.nextLine();
        System.out.print("||| CONTACT MIDDLE NAME   : ");
        String middleName = input.nextLine();
        System.out.print("||| CONTACT LAST NAME     : ");
        String lastName = input.nextLine();
        System.out.print("||| CONTACT PHONE NUMBER  : ");
        String phoneNumber = input.nextLine();
        System.out.print("||| CONTACT EMAIL         : ");
        String email = input.nextLine();
        System.out.print("||| CONTACT ADDRESS       : ");
        String address = input.nextLine();

        Design.border();
        Design.choices("1) MALE     2) FEMALE     3) OTHERS");
        Design.border();
        System.out.print("||| CONTACT GENDER       : ");
        int gender = input.nextInt();
        Gender genders = null;
        if (gender >= 1 && gender <= Gender.values().length) {
            genders = Gender.values()[gender - 1];
            input.nextLine();
        } else {
            genders = Gender.OTHERS;
            input.nextLine();
        }

        System.out.println("||| DATE FORMAT           (YYYY-MM-DD)");
        System.out.print("||| CONTACT BIRTH DAY    : ");
        String birthDay = input.nextLine();

        String formatBirthDay = BirthDay.format(birthDay);

        long age = GenerateAge.age(birthDay);

        System.out.print("||| CONTACT COMPANY      : ");
        String company = input.nextLine();
        System.out.print("||| CONTACT JOB TITLE    : ");
        String jobTitle = input.nextLine();

        Design.border();
        Design.choices("1) FAMILY    2) FRIEND     3) SCHOOL    4) CLIENT     5) WORK     6) BUSINESS     7) OTHERS");
        Design.border();
        System.out.print("||| CONTACT CATEGORY     : ");
        int category = input.nextInt();
        input.nextLine();
        Category categories = null;
        if (category >= 1 && category <= Category.values().length) {
            categories = Category.values()[category - 1];
        } else {
            categories = Category.OTHERS;
        }

        System.out.print("||| CONTACT NOTES        : ");
        String notes = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate createdAt = LocalDate.parse(GenerateDate.currentDate(), formatter);
        LocalDate updatedAt = LocalDate.parse(GenerateDate.currentDate(), formatter);


        Contact contact = new Contact(firstName, middleName, lastName, phoneNumber, email, address, genders, formatBirthDay,
                (int) age, company, jobTitle, categories, notes, createdAt, updatedAt);

        if (contactService.create(contact)) {
            Design.border();
            Design.status( contact.getContactId() + " REGISTER SUCCESSFULLY");
        } else {
            Design.status("REGISTER FAILED PLEASE TRY AGAIN");
        }
    }

    public void viewAllController() {
        List<Contact> contact = contactService.read();

        for (Contact c : contact) {
            if (c != null) {
                System.out.printf("||| ID: %-21s | FULL NAME: %-26s | BIRTH DAY: %-13s | AGE: %-10s | GENDER: %-10s | CATEGORY: %-14s |||\n", c.getContactId(), c.getFullName(), c.getBirthDay(), c.getAge(), c.getGender(), c.getCategory());
                System.out.printf("||| NUMBER: %-17s | EMAIL: %-30s | COMPANY: %-33s | JOB TITLE: %-34s |||\n", c.getPhoneNumber(), c.getEmail(), c.getCompany(), c.getJobTitle());
                System.out.printf("||| ADDRESS: %-149s |||\n", c.getAddress());
                System.out.printf("||| NOTES: %-151s |||\n", c.getNotes());
                System.out.printf("||| CREATED-AT: %-13s | UPDATED-AT: %-118s |||\n", c.getCreatedAt(), c.getUpdatedAt());
                Design.border();
            }
        }
    }

    public void updateController() {
        while (true) {
            System.out.print("||| CONTACT ID: ");
            String contactId = input.nextLine();
            if (contactId.equals("0")) break;

            Design.border();
            Design.choices("0) EXIT UPDATE    1) FIRST NAME    2) MIDDLE NAME    3) LAST NAME    4) PHONE NUMBER    5) EMAIL    6) ADDRESS");
            Design.choices("7) GENDER    8) BIRTH DAY    9) COMPANY    10) JOB TITLE    11) CATEGORY    12) NOTES");
            Design.border();

            System.out.print("||| CHOOSE UPDATE: ");
            int choice = input.nextInt();
            if (choice == 0) break;
            input.nextLine();

            String[] choices = {"EXIT UPDATE", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "PHONE NUMBER", "EMAIL", "ADDRESS", "GENDER", "BIRTHD DAY", "COMPANY", "JOB TITLE", "CATEGORY", "NOTES"};

            Object newValue = null;
            if (choice >= 1 && choice <= 12 ) {
                if (choice == 7) {
                    Design.choices("1) MALE    2) FEMALE    3) OTHERS");
                    System.out.print("||| UPDATE " + choices[choice] + ": ");
                    int gender = input.nextInt();
                    newValue = Gender.values()[gender - 1];

                } else if (choice == 8) {
                    Design.choices("1) MALE    2) FEMALE    3) OTHERS");
                    System.out.print("||| UPDATE " + choices[choice] + ": ");
                    newValue = LocalDate.parse(input.nextLine());

                } else if (choice == 11) {
                    Design.choices("1) MALE    2) FEMALE    3) OTHERS");
                    System.out.print("||| UPDATE " + choices[choice] + ": ");
                    int category = input.nextInt();
                    newValue = Category.values()[category - 1];

                } else {
                    System.out.print("||| UPDATE " + choices[choice] + ": ");
                    newValue = input.nextLine();
                    if (newValue.equals("0")) break;
                }

                boolean contact = contactService.update(contactId, choice, newValue);

                if (contact) {
                    Design.border();
                    Design.status("UPDATE SUCCESSFULLY");
                    Design.border();
                    break;
                } else {
                    Design.border();
                    Design.status("UPDATE FAILED");
                    Design.border();
                }
            } else {
                Design.border();
                Design.status("INVALID CHOICE PLEASE TRY AGAIN");
                Design.border();
            }
        }
    }


    public void deleteController() {
        System.out.print("||| ACCOUNT ID: ");
        String accountId = input.nextLine();

        boolean deleteAccount = contactService.delete(accountId);

        if (deleteAccount) {
            Design.status("CONTACT SUCCESSFULLY DELETED");
        } else {
            Design.status("CONTACT ID NOT FOUND");
        }
    }
}
