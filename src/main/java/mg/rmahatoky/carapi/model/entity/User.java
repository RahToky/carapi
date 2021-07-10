package mg.rmahatoky.carapi.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Mahatoky
 */
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "pseudo")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Le pseudo est obligatoire")
    @NotBlank(message = "Le pseudo ne doit pas être vide")
    @Length(min = 4, max = 10,message = "Le pseudo doit être entre 4 et 10 caractères")
    private String pseudo;

    @NotNull(message = "Le mot de passe est obligatoire")
    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    @Min(4)
    private String password;

    private String photo;

    private String token;

}
