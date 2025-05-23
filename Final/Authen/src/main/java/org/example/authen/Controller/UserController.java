package org.example.authen.Controller;

import org.example.authen.Entities.User;
import org.example.authen.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(Integer.parseInt(password));
        return passwordEncoder.toString();
    }

    @PostMapping("/save")
    public ResponseEntity<?> savaUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        String password = user.getPassword();
        password = encodePassword(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
           return ResponseEntity.ok().build();
    }
    //@PostMapping("/login")
   // public ResponseEntity<?> login(User user) {

    //}
}

