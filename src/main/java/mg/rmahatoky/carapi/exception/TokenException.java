package mg.rmahatoky.carapi.exception;

/**
 * Permet de signaler s'il y a une erreur lier au token
 *
 * @author Mahatoky
 */
public class TokenException extends RuntimeException {

    public TokenException(String error) {
        super(error);
    }

}
