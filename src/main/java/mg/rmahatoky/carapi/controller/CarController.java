package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.Car;
import mg.rmahatoky.carapi.model.Comment;
import mg.rmahatoky.carapi.service.CarService;
import mg.rmahatoky.carapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * API pour afficher et/ou commenter des voitures
 *
 * @author Mahatoky
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/cars")
    public Iterable<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<Void> saveComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.saveComment(comment);
        if (savedComment == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedComment.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
