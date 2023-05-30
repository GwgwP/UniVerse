package gr.aueb.softeng.team02;
public class UniverseException extends RuntimeException{

    public UniverseException() { }

    public UniverseException(String message) {
        super(message);
    }

    public UniverseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniverseException(Throwable cause) {
        super(cause);
    }
}
