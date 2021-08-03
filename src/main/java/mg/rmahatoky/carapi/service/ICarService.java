package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.entity.Car;

/**
 * Interface métier pour les {@link Car}
 *
 * @author Mahatoky
 */
public interface ICarService {


    /**
     * Pour recuperer la liste de toutes les voitures
     *
     * @return la liste des voitures
     */
    Iterable<Car> getCars();

    Car saveCar(Car car);

    Car findCarById(int id);

}
