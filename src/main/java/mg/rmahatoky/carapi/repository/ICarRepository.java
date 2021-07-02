package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Permet de faire des opérations CRUD dans la table CAR
 * @author Mahatoky
 */
@Repository
public interface ICarRepository extends CrudRepository<Car,Long> {
}
