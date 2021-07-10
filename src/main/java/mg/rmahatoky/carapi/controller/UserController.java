package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.exception.UserNotFoundException;
import mg.rmahatoky.carapi.model.entity.User;
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

    /**
     * Authentification {@link User}
     *
     * @param user contient le pseudo et le password hasher en SHA-256
     * @return le detail de l'{@link User} + token ou message d'erreur au cas échéant.
     */
    @PostMapping(value = BASE_URL + "/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        User findUser = userService.authenticate(user);
        if (findUser != null) {
            String token = getJWTToken(user.getPseudo());
            findUser.setToken(token.split(" ")[1]);
            userService.saveToken(findUser);
            return ResponseEntity.ok(findUser);
        } else {
            throw new UserNotFoundException("Pseudo ou mot de passe incorrect");
        }
    }


    // TODO: à corriger
    private String getJWTToken(String username) {
       /* String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        /*String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();*/

        return "Bearer " + System.currentTimeMillis();
    }


}
