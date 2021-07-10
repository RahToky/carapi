package mg.rmahatoky.carapi.model.dto.response;

import lombok.Data;
import mg.rmahatoky.carapi.model.entity.User;

import javax.validation.constraints.NotNull;

/**
 * Contient tous les informations de l'utilisateur sauf son mot de passe.
 * Correspond au class {@link User} mais sans password
 *
 * @author Mahatoky
 */
@Data
public class AuthResponse {

    private int id;
    private String pseudo;
    private String token;
    private String photo;

    public AuthResponse(@NotNull User user) {
        this.id = user.getId();
        this.pseudo = user.getPseudo();
        this.token = user.getToken();
        this.photo = user.getPhoto();
    }

}
