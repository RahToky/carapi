package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.entity.Car;
import mg.rmahatoky.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API pour les {@link Car}
 *
 * @author Mahatoky
 */
@RestController
public class CarController {

    public static final String BASE_URL = "/cars";

    @Autowired
    private CarService carService;

    @GetMapping(value = BASE_URL)
    public ResponseEntity<Iterable<Car>> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }

}
