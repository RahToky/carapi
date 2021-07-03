package mg.rmahatoky.carapi.repository;

import mg.rmahatoky.carapi.model.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Permet de faire des opérations CRUD dans la table {@link Comment}
 * @author Mahatoky
 */
@Repository
public interface ICommentRepository extends CrudRepository<Comment,Integer> {

    List<Comment> findCommentsByCarId(int id);

}
