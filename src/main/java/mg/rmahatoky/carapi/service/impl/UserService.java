package mg.rmahatoky.carapi.service.impl;

import lombok.Data;
import mg.rmahatoky.carapi.exception.UserNotFoundException;
import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import mg.rmahatoky.carapi.model.dto.response.AuthResponse;
import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.repository.IUserRepository;
import mg.rmahatoky.carapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Couche métier pour les {@link User}
 *
 * @author Mahatoky
 */
@Data
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User authenticate(AuthRequest user) {
        User u = userRepository.findFirstByPseudoAndPassword(user.getPseudo(), user.getPassword());
        if (u != null)
            return u;
        throw new UserNotFoundException("Pseudo ou mot de passe incorrect");
    }

    @Override
    public User findUserById(int id){
        return userRepository.findUserById(id);
    }

    @Override
    public void saveToken(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

}
