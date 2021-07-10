package mg.rmahatoky.carapi.service;

import lombok.Data;
import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * Pour chercher l'{@link User}
     * Le mot de passe sera encrypter en {@link sun.security.provider.MD5}
     *
     * @param user contient l'information de l'{@link User}
     * @return l'information de l'{@link User}
     */
    public User authenticate(User user) {
        return userRepository.findFirstByPseudoAndPassword(user.getPseudo(), user.getPassword());
    }

    public User findUserByToken(String token) {
        return userRepository.findFirstByToken(token);
    }

    public void saveToken(User user) {
        userRepository.save(user);
    }

}
