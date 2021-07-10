package mg.rmahatoky.carapi.exception;

/**
 * @author Mahatoky
 */
public class TokenException extends RuntimeException {

    public TokenException(String error) {
        super(error);
    }

}
