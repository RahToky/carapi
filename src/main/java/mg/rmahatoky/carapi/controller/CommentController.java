package mg.rmahatoky.carapi.controller;

import mg.rmahatoky.carapi.model.entity.Comment;
import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.model.exception.ErrorResponse;
import mg.rmahatoky.carapi.model.exception.TokenException;
import mg.rmahatoky.carapi.model.util.TokenUtil;
import mg.rmahatoky.carapi.service.CommentService;
import mg.rmahatoky.carapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    private static final String BASE_URL = "/cars/{carId}/comments";

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping(value = BASE_URL)
    public ResponseEntity<List<Comment>> getCommentByCarId(@PathVariable int carId) {
        return ResponseEntity.ok(commentService.findCommentsByCarId(carId));
    }

    @PostMapping(value = BASE_URL)
    public ResponseEntity<Object> comment(@RequestHeader HttpHeaders headers, @RequestBody Comment comment, @PathVariable int carId) {


        try {
            String token = TokenUtil.getToken(headers);
            User user = userService.findUserByToken(token);

            if(user == null || comment.getUserId() != user.getId())
                throw new TokenException("Token invalide");

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
        } catch (TokenException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(401,"Unauthorized",e.getMessage(),BASE_URL.replace("{carId}",String.valueOf(carId))));
        }
    }


}
