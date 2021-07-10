package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import mg.rmahatoky.carapi.model.dto.response.AuthResponse;
import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.security.JwtUtils;
import mg.rmahatoky.carapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Authentification {@link User}
     *
     * @param user contient le pseudo et le password hasher en SHA-256
     * @return le detail de l'{@link User} + token ou message d'erreur au cas échéant.
     */
    @PostMapping(value = BASE_URL + "/login")
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
    @GetMapping(value = BASE_URL)
    public Iterable<User> getUsers() {
        return userService.findAllUsers();
    }

}
