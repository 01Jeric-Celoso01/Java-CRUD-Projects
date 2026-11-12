package org.jcc.service;

import org.jcc.implement.ContactImplement;
import org.jcc.model.Contact;
import org.jcc.util.Uppercase;

import java.util.List;

public class ContactService {
    private final ContactImplement IMPLEMENT;

    public ContactService(ContactImplement implement) { this.IMPLEMENT = implement; }

    public boolean create(Contact contact) {

        contact.setFirstName(Uppercase.firstCharacter(contact.getFirstName()));
        contact.setMiddleName(Uppercase.firstCharacter(contact.getMiddleName()));
        contact.setLastName(Uppercase.firstCharacter(contact.getLastName()));

        return IMPLEMENT.create(contact);
    }

    public List<Contact> read() { return IMPLEMENT.read(); }
    public boolean update(String id, int choice, Object newValue) { return IMPLEMENT.update(id, choice, newValue);
    }
    public boolean delete(String id) { return IMPLEMENT.delete(id); }
}
