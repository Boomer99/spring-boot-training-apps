package com.neueda.payments.control;

import com.neueda.payments.model.Payment;
import com.neueda.payments.model.User;
import com.neueda.payments.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

}
