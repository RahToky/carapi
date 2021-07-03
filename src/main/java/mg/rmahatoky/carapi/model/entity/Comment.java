package mg.rmahatoky.carapi.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Mahatoky
 */
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "user_id")
    private int userId;

    @NotNull
    private String text;

}
