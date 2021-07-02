package mg.rmahatoky.carapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String img;

}
