package org.jcc.implement;

import org.jcc.db.ContactDB;
import org.jcc.enums.Category;
import org.jcc.enums.Gender;
import org.jcc.repository.ContactRepository;
import org.jcc.model.Contact;
import org.jcc.ui.Design;
import org.jcc.util.GenerateDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactImplement implements ContactRepository {
    final List<Contact> CONTACT = new ArrayList<>(ContactDB.data());


        @Override
        public boolean create(Contact contact) {
            if (contact != null) {
                CONTACT.add(contact);
                return true;
            }
            return false;
        }


    @Override
    public List<Contact> read() {
        return CONTACT;
    }


    @Override
    public boolean update(String id, int choice, Object newValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        for (Contact c : CONTACT) {
            if (c.getContactId().equals(id)) {
                switch (choice) {
                    case 1:
                        c.setFirstName((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 2:
                        c.setMiddleName((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 3:
                        c.setLastName((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 4:
                        c.setPhoneNumber((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 5:
                        c.setEmail((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 6:
                        c.setAddress((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 7:
                        c.setGender((Gender) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 8:
                        c.setBirthDay((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 9:
                        c.setCompany((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 10:
                        c.setJobTitle((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 11:
                        c.setCategory((Category) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    case 12:
                        c.setNotes((String) newValue);
                        c.setUpdatedAt(LocalDate.parse(GenerateDate.currentDate(), formatter));
                        break;
                    default:
                        Design.status("INVALID CHOICE PLEASE TRY AGAIN!");
                        break;
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean delete(String id) {
        Iterator<Contact> iterate = CONTACT.iterator();

        while (iterate.hasNext()) {
            Contact contact = iterate.next();

            if (contact.getContactId().equals(id)) {
                iterate.remove();
                return true;
            }
        }
        return false;
    }
}
