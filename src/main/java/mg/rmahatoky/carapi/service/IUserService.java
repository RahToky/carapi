package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import mg.rmahatoky.carapi.model.entity.User;

/**
 * Interface métier pour les {@link User}
 *
 * @author Mahatoky
 */
public interface IUserService {


    /**
     * Pour chercher l'{@link User}
     * Le mot de passe sera encrypter en {@link sun.security.provider.MD5}
     *
     * @param user contient l'information de l'{@link User}
     * @return l'information de l'{@link User}
     */
    User authenticate(AuthRequest user);

    User findUserById(int id);

    void saveToken(User user);

    Iterable<User> findAllUsers();


}
