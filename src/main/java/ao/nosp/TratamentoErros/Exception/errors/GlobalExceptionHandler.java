package ao.nosp.TratamentoErros.Exception.errors;

import ao.nosp.TratamentoErros.Exception.ResourceBadRequestException;
import ao.nosp.TratamentoErros.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    // Tratar exceções específicas
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


        @ExceptionHandler(ResourceBadRequestException.class)
        public ResponseEntity<List<ErrorDetails>> handleValidationException(ResourceBadRequestException ex, WebRequest request) {
            return new ResponseEntity<>(validate(ex), HttpStatus.BAD_REQUEST);
        }

    private static List<ErrorDetails> validate(ResourceBadRequestException ex) {
        List<ErrorDetails> errors = new ArrayList<>();
        for (int i = 0; i <=2 ; i++) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Request Invaládo", ex.getMessage());
            errors.add(errorDetails);
        }
        return errors;
    }





    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Access Denied", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }




}
