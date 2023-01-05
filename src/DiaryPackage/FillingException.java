package DiaryPackage;
import lombok.Getter;

@Getter
public class FillingException extends Exception{

    public FillingException(String message){
        super(message);
    }
}
