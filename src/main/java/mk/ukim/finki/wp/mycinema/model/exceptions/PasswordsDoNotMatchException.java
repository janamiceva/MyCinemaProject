package mk.ukim.finki.wp.mycinema.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords Do Not Match");
    }
}