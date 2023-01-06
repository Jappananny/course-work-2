package DiaryPackage;
import lombok.Getter;
import java.time.LocalDate;
@Getter
public class TaskRepeatability {
    public static TaskRepeatability SINGLE;
    public static TaskRepeatability DAILY;
    public static TaskRepeatability WEEKLY;
    public static TaskRepeatability MONTHLY;
    public static TaskRepeatability YEARLY;
    private static TaskRepeatability[] VALUES = new TaskRepeatability[5];
    private  String format;
    private int number;

    public TaskRepeatability(String format, int number) {
        this.format = format;
        this.number = number;
    }

    {
        SINGLE = new TaskRepeatability("Однократная задача", 0);
        DAILY = new TaskRepeatability("Ежедневная задача", 1);
        WEEKLY = new TaskRepeatability("Еженедельная задача", 2);
        MONTHLY = new TaskRepeatability("Ежемесячная задача", 3);
        YEARLY = new TaskRepeatability("Ежегодная задача", 4);
        VALUES = new TaskRepeatability[]{SINGLE, DAILY, WEEKLY, MONTHLY, YEARLY};
    }


    public static TaskRepeatability[] values() {
        return VALUES.clone();
    }

    public TaskRepeatability[] valueOf(String format) {
        return TaskRepeatability.values();
    }

    public void SINGLE() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

    public void DAILY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusDays(1));

    }

    public void WEEKLY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusWeeks(1));
    }

    public void MONTHLY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusMonths(1));
    }

    public void YEARLY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusYears(1));
    }
}
