package evenAPK.authentification.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import evenAPK.authentification.Repository.UsersRepository;

@RestController
@RequestMapping("/Users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;


}
