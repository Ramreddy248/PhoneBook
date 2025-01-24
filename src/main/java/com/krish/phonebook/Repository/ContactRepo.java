package com.krish.phonebook.Repository;

import com.krish.phonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Integer> {

}
