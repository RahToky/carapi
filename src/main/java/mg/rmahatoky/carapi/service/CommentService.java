package mg.rmahatoky.carapi.service;

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

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
