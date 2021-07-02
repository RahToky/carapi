package mg.rmahatoky.carapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Comment{

    @Id
    @GeneratedValue
    protected int id;

    @NotNull
    private String text;

}
