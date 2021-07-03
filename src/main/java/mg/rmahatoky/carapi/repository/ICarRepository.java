package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Permet de faire des opérations CRUD dans la table {@link Car}
 *
 * @author Mahatoky
 */
@Repository
public interface ICarRepository extends CrudRepository<Car, Integer> {
}
