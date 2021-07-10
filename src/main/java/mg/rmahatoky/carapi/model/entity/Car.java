package mg.rmahatoky.carapi.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Mahatoky
 */
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "La marque est obligatoire")
    @NotBlank(message = "La marque ne doit pas être vide")
    @Length(min = 1, max = 30)
    private String brand;

    @NotNull(message = "Le model est obligatoire")
    @NotBlank(message = "Le model ne doit pas être vide")
    @Length(min = 1, max = 30)
    private String model;

    @NotNull
    private String photo;

}
