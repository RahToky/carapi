package mg.rmahatoky.carapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Comment{

    @Id
    @GeneratedValue
    private int id;

    @Column(name="car_id")
    private int carId;

    @Column(name="user_id")
    private int userId;

    @NotNull
    private String text;

}
