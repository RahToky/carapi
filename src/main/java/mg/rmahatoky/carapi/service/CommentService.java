package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.exception.DataSaveException;
import mg.rmahatoky.carapi.exception.RequestBodyException;
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

    public int saveComment(PostCommentRequest commentRequest, int carId) {
        if (commentRequest.getUserId() == 0 || commentRequest.getText() == null || commentRequest.getText().trim().isEmpty())
            throw new RequestBodyException();
        Comment comment = new Comment();
        comment.setCarId(carId);
        comment.setUserId(commentRequest.getUserId());
        comment.setText(commentRequest.getText());
        Comment commentResponse = commentRepository.save(comment);
        if (commentResponse != null)
            return commentResponse.getUserId();
        throw new DataSaveException();
    }
}
