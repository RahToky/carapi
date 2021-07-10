package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Permet de faire des opérations CRUD dans la table {@link User}
 *
 * @author Mahatoky
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findFirstByPseudoAndPassword(String pseudo, String password);

    @Query(value = "SELECT u FROM User u WHERE u.id = (SELECT ut.userId FROM UserToken ut WHERE ut.token = :token)")
    User findUserByUserToken(@Param("token") String token);

}
