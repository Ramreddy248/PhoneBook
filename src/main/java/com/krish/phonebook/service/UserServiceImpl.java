package com.krish.phonebook.service;

import com.krish.phonebook.Repository.ContactRepo;
import com.krish.phonebook.Repository.UserRepo;
import com.krish.phonebook.model.Contact;
import com.krish.phonebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public User add(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findByName(String name) {
        User user=userRepo.findByName(name);
        return user;
    }

    @Override
    public Contact addcontact(User user, Contact contact) {
        List<Contact> list=user.getList();
        list.add(contact);
        user.setList(list);
     //   userRepo.save(user);
        return contactRepo.save(contact);
    }

    
}
