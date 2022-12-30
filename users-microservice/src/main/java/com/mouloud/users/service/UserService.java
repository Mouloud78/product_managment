package com.mouloud.users.service;

import com.mouloud.users.entities.Role;
import com.mouloud.users.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);

}
