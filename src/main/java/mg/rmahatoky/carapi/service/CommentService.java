package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.dto.request.PostCommentRequest;
import mg.rmahatoky.carapi.model.entity.Comment;
import mg.rmahatoky.carapi.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Couche métier pour les {@link Comment}
 *
 * @author Mahatoky
 */
@Service
public class CommentService {

    @Autowired
    private ICommentRepository commentRepository;

    public List<Comment> findCommentsByCarId(int id) {
        return commentRepository.findCommentsByCarId(id);
    }

    public Comment saveComment(PostCommentRequest commentRequest, int carId) {
        Comment comment = new Comment();
        comment.setCarId(carId);
        comment.setUserId(commentRequest.getUserId());
        comment.setText(commentRequest.getText());
        return commentRepository.save(comment);
    }
}
