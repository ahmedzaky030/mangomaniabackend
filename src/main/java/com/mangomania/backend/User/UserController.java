package com.mangomania.backend.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping()
    public @ResponseBody User save(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping()
    public @ResponseBody Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping()
    public @ResponseBody User findById(@RequestParam Integer id) {
        return  userRepository.findById(id).orElse(null);
    }

    @PutMapping()
    public @ResponseBody User update(@RequestBody User oldUser) {
        return userRepository.save(oldUser);
    }

    @DeleteMapping()
    public boolean delete(@RequestParam Integer id) {
       try {
           userRepository.deleteById(id);
           return true;
            }
       catch (Exception e) {
           return false;
       }
    }



}
