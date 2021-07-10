package mg.rmahatoky.carapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Permet de signaler s'il y a une erreur dans le body JSON d'une requette
 *
 * @author Mahatoky
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestBodyException extends RuntimeException {

    public RequestBodyException() {
        super("Verifier le corps de votre requette");
    }

    public RequestBodyException(String message) {
        super(message);
    }

}
