package mg.rmahatoky.carapi.service.impl;

import lombok.Data;
import mg.rmahatoky.carapi.model.entity.Car;
import mg.rmahatoky.carapi.repository.ICarRepository;
import mg.rmahatoky.carapi.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Couche métier pour les {@link Car}
 *
 * @author Mahatoky
 */
@Data
@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository carRepository;

    /**
     * Pour recuperer la liste de toutes les voitures
     *
     * @return la liste des voitures
     */
    @Override
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findCarById(int id) {
        return carRepository.findById(id).get();
    }
}