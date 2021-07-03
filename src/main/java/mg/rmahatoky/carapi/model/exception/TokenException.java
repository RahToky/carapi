package mg.rmahatoky.carapi.model.exception;

/**
 * @author Mahatoky
 */
public class TokenException extends Exception{

    /**
     * On capitalise le message
     */
    public TokenException(String error){
        super(error);
    }

}
