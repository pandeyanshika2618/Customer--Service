package customerservice.example.customer.Service.exceptionHandler;

public class RegisterationDuplicacyException extends  RuntimeException {
    public RegisterationDuplicacyException(String message)
    {
        super(message);
    }
}
