package mg.rmahatoky.carapi.model.dto.request;

import lombok.Data;

/**
 * @author Mahatoky
 */
@Data
public class AuthRequest {

    private String pseudo;
    private String password;

}
