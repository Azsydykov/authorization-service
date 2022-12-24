package kg.mogacom.authorizationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler  {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(RuntimeException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(AuthExc e){
        return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleException(AccountNotFoundExc e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
