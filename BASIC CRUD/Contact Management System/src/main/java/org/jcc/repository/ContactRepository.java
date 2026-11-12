package org.jcc.repository;

import org.jcc.model.Contact;

import java.util.List;

public interface ContactRepository {
    boolean create(Contact contact);
    List<Contact> read();
    boolean update(String id, int choice, Object newValue);
    boolean delete(String id);
}
