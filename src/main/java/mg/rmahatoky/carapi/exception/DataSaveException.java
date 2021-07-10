package mg.rmahatoky.carapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Permet de signaler s'il y a une erreur lier au sauvegarde d'un donné
 *
 * @author Mahatoky
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DataSaveException extends RuntimeException {

    public DataSaveException() {
        super("Echec de la sauvegarde");
    }

    public DataSaveException(String message) {
        super(message);
    }

}
