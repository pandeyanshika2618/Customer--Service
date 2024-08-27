package customerservice.example.customer.Service.exceptionHandler;

public class InvalidCredentialsException extends Exception{
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
