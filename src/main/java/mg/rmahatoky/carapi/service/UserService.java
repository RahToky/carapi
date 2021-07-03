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
     *
     * @param user contient l'information de l'{@link User}
     * @return l'information de l'{@link User}
     */
    public User authenticate(User user){
        if(user.getPseudo().equals("mahatoky") && user.getPassword().equals("1234")) {
            user.setId(1);
            return user;
        }else{
            return null;
        }
    }

}
