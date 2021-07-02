package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends CrudRepository<Comment,Integer> {
}
