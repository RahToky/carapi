package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.entity.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mahatoky
 */
@Repository
public interface IUserTokenRepository extends CrudRepository<UserToken, Integer> {
}
