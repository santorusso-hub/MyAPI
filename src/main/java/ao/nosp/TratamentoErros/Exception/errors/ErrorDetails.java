package ao.nosp.TratamentoErros.Exception.errors;
import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String field;

    public ErrorDetails(LocalDateTime timestamp, String message, String field) {
        this.timestamp = timestamp;
        this.message = message;
        this.field = field;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String details) {
        this.field = field;
    }
}
