package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.model.exception.ErrorResponse;
import mg.rmahatoky.carapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = BASE_URL + "/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        User findUser = userService.authenticate(user);
        if(findUser != null)
            return ResponseEntity.ok(userService.authenticate(user));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404,"authentification","Pseudo ou mot de passe incorrect",BASE_URL+"/login"));
    }

}
