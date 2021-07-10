package mg.rmahatoky.carapi.model.dto.request;

import lombok.Data;

/**
 * Pour contenir seulement le pseudo et le mot de passe de l'utilisateur
 * Utiliser comme body de la requette lors de l'authentification
 *
 * @author Mahatoky
 */
@Data
public class AuthRequest {

    private String pseudo;
    private String password;

}
