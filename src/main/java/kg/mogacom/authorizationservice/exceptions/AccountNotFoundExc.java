package kg.mogacom.authorizationservice.exceptions;

public class AccountNotFoundExc extends RuntimeException {
    public AccountNotFoundExc(String message) {
        super(message);
    }
}
