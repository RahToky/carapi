package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Permet de faire des opérations CRUD dans la table {@link User}
 * @author Mahatoky
 */
@Repository
public interface IUserRepository extends CrudRepository<User,Integer> {

    User findFirstByPseudoAndPassword(String pseudo, String password);

}
