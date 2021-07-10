package mg.rmahatoky.carapi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Utiliser comme corps de la requette pour poster un commentaire
 *
 * @author Mahatoky
 */
@Data
public class PostCommentRequest {

    @JsonProperty("user_id")
    private int userId;

    @NotNull
    private String text;
}
