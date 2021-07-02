package mg.rmahatoky.carapi.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Car extends BaseModel{

    @NotNull
    @Length(min = 1,max = 30)
    private String brand;

    @NotNull
    @Length(min = 1,max = 30)
    private String model;

    @NotNull
    private String img;

}
