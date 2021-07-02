package mg.rmahatoky.carapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Comment extends BaseModel{

    private String text;

}
