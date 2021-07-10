package mg.rmahatoky.carapi.service;

import lombok.Data;
import mg.rmahatoky.carapi.exception.UserNotFoundException;
import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import mg.rmahatoky.carapi.model.dto.response.AuthResponse;
import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.model.entity.UserToken;
import mg.rmahatoky.carapi.repository.IUserRepository;
import mg.rmahatoky.carapi.repository.IUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Couche métier pour les {@link User}
 *
 * @author Mahatoky
 */
@Data
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserTokenRepository userTokenRepository;

    /**
     * Pour chercher l'{@link User}
     * Le mot de passe sera encrypter en {@link sun.security.provider.MD5}
     *
     * @param user contient l'information de l'{@link User}
     * @return l'information de l'{@link User}
     */
    public AuthResponse authenticate(AuthRequest user) {
        User u = userRepository.findFirstByPseudoAndPassword(user.getPseudo(), user.getPassword());
        if (u != null)
            return new AuthResponse(u);
        throw new UserNotFoundException("Pseudo ou mot de passe incorrect");
    }

    public User findUserByToken(String token) {
        return userRepository.findUserByUserToken(token);
    }

    public void saveToken(UserToken userToken) {
        userTokenRepository.save(userToken);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

}
