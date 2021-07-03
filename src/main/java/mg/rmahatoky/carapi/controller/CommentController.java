package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.Comment;
import mg.rmahatoky.carapi.service.CommentService;
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

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/cars/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentByCarId(@PathVariable int id){
        return ResponseEntity.ok(commentService.findCommentsByCarId(id));
    }

    @PostMapping(value = "/cars/{id}/comments")
    public ResponseEntity<Void> comment(@RequestBody Comment comment) {
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
