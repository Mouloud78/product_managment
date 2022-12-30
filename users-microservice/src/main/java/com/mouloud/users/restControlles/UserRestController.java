package com.mouloud.users.restControlles;


import com.mouloud.users.entities.User;
import com.mouloud.users.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    UserRepository userRep;

    @RequestMapping(path = "all",method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRep.findAll();
    }
}
