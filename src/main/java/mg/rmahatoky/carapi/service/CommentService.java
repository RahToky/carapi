package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.Comment;
import mg.rmahatoky.carapi.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private ICommentRepository commentRepository;

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
}
