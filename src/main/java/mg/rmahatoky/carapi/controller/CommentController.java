package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.dto.request.PostCommentRequest;
import mg.rmahatoky.carapi.model.entity.Comment;
import mg.rmahatoky.carapi.service.impl.CommentService;
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
@RequestMapping("/cars/{carId}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * Permet d'acceder aux commentaires à propors d'une voiture
     * Necessite une Authorisation Bearer Token
     *
     * @param carId
     * @return la liste des commentaires à propos d'une voiture
     */
    @GetMapping()
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
    @PostMapping()
    public ResponseEntity<Object> comment(@RequestBody PostCommentRequest comment, @PathVariable int carId) {

        int savedCommentId = commentService.saveComment(comment, carId);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCommentId)
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
