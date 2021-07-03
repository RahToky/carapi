package mg.rmahatoky.carapi.model.exception;

import lombok.Data;

/**
 * Message d'erreur comme reponse à une requette
 *
 * @author Mahatoky
 */
@Data
public class ErrorResponse {

    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
