package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import mg.rmahatoky.carapi.model.entity.User;

public interface IUserService {

    User authenticate(AuthRequest user);

    User findUserById(int id);

    void saveToken(User user);

    Iterable<User> findAllUsers();


}
