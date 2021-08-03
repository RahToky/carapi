package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.entity.Car;
import mg.rmahatoky.carapi.service.impl.CarService;
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
@RequestMapping("/cars")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public Iterable<Car> getCars() {
        return carService.getCars();
    }

    /**
     * Enregistre un {@link Car}
     * @param car l'image doit être en base64
     * @return
     */
    @PostMapping()
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

    @GetMapping(value = "/{id}")
    public Car findCarById(@PathVariable int id){
        return carService.findCarById(id);
    }

}
