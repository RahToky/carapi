package mg.rmahatoky.carapi.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User extends BaseModel{

    @NotNull
    @Length(min = 4,max = 10)
    private String pseudo;

    @NotNull
    @Min(4)
    private String password;

}
