package level1.exercise1.exceptions;
import java.lang.Exception;

public class EmptySaleException extends Exception{

    public EmptySaleException(String message){
        super(message);
    }
}
