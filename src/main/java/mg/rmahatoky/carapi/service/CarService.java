package mg.rmahatoky.carapi.service;

import lombok.Data;
import mg.rmahatoky.carapi.model.Car;
import mg.rmahatoky.carapi.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Couche métier
 * @author Mahatoky
 */
@Data
@Service
public class CarService {

    @Autowired
    private ICarRepository carRepository;

    /**
     * Pour recuperer la liste de toutes les voitures
     * @return la liste des voitures
     */
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }


}