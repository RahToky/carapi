package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.User;
import mg.rmahatoky.carapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * API pour les {@link User}
 *
 * @author Mahatoky
 */
@RestController
public class UserController {

    public static final String BASE_URL = "/users";

    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return null;
    }

}
