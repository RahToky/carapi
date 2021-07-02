package mg.rmahatoky.carapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
abstract class BaseModel {
    @Id
    @GeneratedValue
    protected int id;
}
