package com.krish.phonebook.controller;

import com.krish.phonebook.model.Contact;
import com.krish.phonebook.model.User;
import com.krish.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<String> welcome(){

        return ResponseEntity.ok("welcome");
    }


    @PostMapping("/register")
    public ResponseEntity<User> Register(@RequestBody User user){
        user=userService.add(user);
       return ResponseEntity.ok(user);
    }

    @PostMapping("/add/{name}")
    public ResponseEntity<User>add(@PathVariable String name ,@RequestBody Contact contact){
        User user =userService.findByName(name);

       Contact contact1=userService.addcontact(user,contact);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getlist/{name}")
    public ResponseEntity<List<Contact>>getList(@PathVariable String name){
        User user =userService.findByName(name);
        return ResponseEntity.ok(user.getList());

    }
    @GetMapping("/getnum/{name}/{cname}")
    public ResponseEntity<Integer>getList(@PathVariable String name,@PathVariable String cname){

        User user =userService.findByName(name);
        Integer num=0;
        for(Contact c: user.getList()){
            if(Objects.equals(c.getName(), cname)){
                num=c.getPhone();
                break;
            }
        }
        return ResponseEntity.ok(num);

    }

}
