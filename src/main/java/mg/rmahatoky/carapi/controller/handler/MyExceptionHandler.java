package mg.rmahatoky.carapi.controller.handler;

import mg.rmahatoky.carapi.exception.TokenException;
import mg.rmahatoky.carapi.exception.UserNotFoundException;
import mg.rmahatoky.carapi.model.dto.ErrorResponse;
import mg.rmahatoky.carapi.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Pour gerer les exceptions
 * @author Mahatoky
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erreur server", e.getMessage()));
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<ErrorResponse> tokenException(TokenException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Non autorisé", e.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Authentification", e.getMessage()));
    }
}
