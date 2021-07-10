package mg.rmahatoky.carapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Mahatoky
 */
@Data
@Entity
@Table(name = "user_token")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    private String token;

    public UserToken(){}

    public UserToken(int userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
