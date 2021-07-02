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
    private ICarRepository repository;

    /**
     * Pour recuperer la liste de toutes les voitures
     * @return la liste des voitures
     */
    public Iterable<Car> getCars(){
        /*ArrayList<Car> cars = new ArrayList();
        Car car = new Car();
        car.setId(1l);
        car.setBrand("BMW");
        car.setModel("X6");

        Car car2 = new Car();
        car2.setId(2l);
        car2.setBrand("AUDI");
        car2.setModel("Q7");

        cars.add(car);
        cars.add(car2);*/
        return repository.findAll();
    }
}