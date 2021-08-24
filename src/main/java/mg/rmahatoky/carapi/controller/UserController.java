package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import mg.rmahatoky.carapi.model.dto.response.AuthResponse;
import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.security.JwtUtils;
import mg.rmahatoky.carapi.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * API pour les {@link User}
 *
 * @author Mahatoky
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * Authentification {@link User}
     *
     * @param user contient le pseudo et le password hasher en SHA-256
     * @return le detail de l'{@link User} + token ou message d'erreur au cas échéant.
     */
    @PostMapping(value = "/login")
    public AuthResponse login(@RequestBody AuthRequest user) {
        User findUser = userService.authenticate(user);
        String token = jwtUtils.generateJwtToken(user);
        findUser.setToken(token);
        userService.saveToken(findUser);
        return new AuthResponse(findUser);
    }


    /**
     * Pour afficher les infos des utilisateurs pour faciliter le test (auth,permission) de l'API
     *
     * @return tous les utilisateurs
     */
    @GetMapping()
    public Iterable<User> getUsers() {
        return userService.findAllUsers();
    }

}
