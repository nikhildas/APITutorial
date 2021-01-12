package example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StateExceptionController {
    @ExceptionHandler(value = StateNotFoundException.class)
    public ResponseEntity<Object> exception(StateNotFoundException exception){
        return new ResponseEntity<>("State not found", HttpStatus.NOT_FOUND);
    }
}
