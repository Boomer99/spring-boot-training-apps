package com.neueda.payments.service;

import com.neueda.payments.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(long id);

    User save(User user);
}
