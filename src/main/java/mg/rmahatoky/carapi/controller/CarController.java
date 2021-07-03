package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.entity.Car;
import mg.rmahatoky.carapi.model.entity.Comment;
import mg.rmahatoky.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping(value = BASE_URL+"/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable int id){
        return ResponseEntity.ok(carService.findCarById(id));
    }

    /**
     * Enregistre un {@link Car}
     * @param car l'image doit être en base64
     * @return
     */
    @PostMapping(value = BASE_URL)
    public ResponseEntity<Void> saveCar(@RequestBody Car car){
        Car saveCar = carService.saveCar(car);
        if (saveCar == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveCar.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
