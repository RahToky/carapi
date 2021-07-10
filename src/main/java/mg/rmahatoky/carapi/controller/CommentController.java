package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.entity.Comment;
import mg.rmahatoky.carapi.service.CommentService;
import mg.rmahatoky.carapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * API pour les {@link Comment}
 *
 * @author Mahatoky
 */
@RestController
public class CommentController {

    public static final String BASE_URL = "/cars/{carId}/comments";

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    /**
     * Permet d'acceder aux commentaires à propors d'une voiture
     * Necessite une Authorisation Bearer Token
     *
     * @param carId
     * @return la liste des commentaires à propos d'une voiture
     */
    @GetMapping(value = BASE_URL)
    public List<Comment> getCommentByCarId(@PathVariable int carId) {
        return commentService.findCommentsByCarId(carId);
    }

    /**
     * Permet de faire un commentaire sur une voiture à condition d'être connecté
     *
     * @param comment le commentaire, doit contenir l'id de l'utilisateur et le commentaire en question
     * @param carId   l'id de la voiture à commenter
     * @return rien sinon erreur Token
     */
    @PostMapping(value = BASE_URL)
    public ResponseEntity<Object> comment(@RequestBody Comment comment, @PathVariable int carId) {
        if (comment.getUserId() == 0)
            return ResponseEntity.badRequest().build();

        comment.setCarId(carId);
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
