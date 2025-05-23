package org.example.authen.Service;

import org.example.authen.Entities.User;
import org.example.authen.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private User authenticatedUser(String username, String password) {
        User user = UserRepository.findByUsername(us)
    };
}
