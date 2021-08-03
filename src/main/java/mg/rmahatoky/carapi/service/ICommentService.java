package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.dto.request.PostCommentRequest;
import mg.rmahatoky.carapi.model.entity.Comment;

import java.util.List;

/**
 * Interface métier pour les {@link Comment}
 *
 * @author Mahatoky
 */
public interface ICommentService {

    List<Comment> findCommentsByCarId(int id);

    int saveComment(PostCommentRequest commentRequest, int carId);

}
