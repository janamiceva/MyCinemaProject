package mk.ukim.finki.wp.mycinema.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException() {
        super("Invalid User Credentials Exception");
    }
}