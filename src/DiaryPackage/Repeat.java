package DiaryPackage;
import lombok.Getter;
@Getter
public enum Repeat {
    SINGLE("Однократная задача"),
    DAILY("Ежедневная задача"),
    WEEKLY("Еженедельная задача"),
    MONTHLY("Ежемесячная задача"),
    YEARLY("Ежегодная задача");
    private final String repeat;
    Repeat(String repeat){
        this.repeat = repeat;
    }
    @Override
    public String toString() {
        return this.repeat;
    }

}
