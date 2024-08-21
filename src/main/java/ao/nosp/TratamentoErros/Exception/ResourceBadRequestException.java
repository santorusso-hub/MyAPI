package ao.nosp.TratamentoErros.Exception;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String message) {
        super(message);
    }
}
