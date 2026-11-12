package org.jcc.db;

import org.jcc.enums.Category;
import org.jcc.enums.Gender;
import org.jcc.model.Contact;
import org.jcc.util.BirthDay;
import org.jcc.util.GenerateAge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDB {
    private static List<Contact> contact = new ArrayList<>();

    public static List<Contact> data() {
        Contact c1 = new Contact( "juan", "dela", "cruz", "09123456789", "jhon@gmail.com", "New Manila", Gender.MALE, BirthDay.format("03011999"), (int) GenerateAge.age("03011999"), "Company ABC", "Production Helper", Category.FRIEND, "Sample Notes", LocalDate.of(2026, 11, 12), LocalDate.of(2026, 11, 12));
        contact.add(c1);

        return contact;
    }
}
