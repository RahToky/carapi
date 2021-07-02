package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.Car;
import mg.rmahatoky.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API pour afficher et/ou commenter des voitures
 * @author Mahatoky
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public Iterable<Car> getCars(){
        return carService.getCars();
    }

}
