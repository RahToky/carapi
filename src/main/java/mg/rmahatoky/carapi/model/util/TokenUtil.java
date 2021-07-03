package mg.rmahatoky.carapi.model.util;

import mg.rmahatoky.carapi.model.exception.TokenException;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Manipule le token
 *
 * @author Mahatoky
 */
public abstract class TokenUtil {

    /**
     * Recupere le token à partir du {@link HttpHeaders}
     *
     * @param headers header de la requette
     * @return le token
     * @throws TokenException si le header ne contient pas d'auhorisation ou le type n'est pas Bearer ou le token est vide
     */
    public static String getToken(HttpHeaders headers) throws TokenException {
        List<String> authorizationList = headers.get("Authorization");
        if (authorizationList == null || authorizationList.size() == 0)
            throw new TokenException("Vous devez vous connecter pour effectuer cette opération");
        String authorization = headers.get("Authorization").get(0);
        if (!authorization.contains("Bearer")) {
            throw new TokenException("Vous devez utiliser Bearer comme type d'autorisation");
        } else {
            String[] authSplit = authorization.split(" ");
            if (authSplit.length == 1)
                throw new TokenException("Token vide");
            else
                return authSplit[1];
        }
    }

}
