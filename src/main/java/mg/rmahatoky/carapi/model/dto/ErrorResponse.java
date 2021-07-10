package mg.rmahatoky.carapi.model.dto;

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

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
