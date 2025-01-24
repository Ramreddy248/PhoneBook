package com.krish.phonebook.service;

import com.krish.phonebook.model.Contact;
import com.krish.phonebook.model.User;

public interface UserService {
       public User add(User user);
       public User findByName(String name);
       public Contact addcontact(User user, Contact contact);

}
