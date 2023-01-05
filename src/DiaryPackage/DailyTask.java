package DiaryPackage;
import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(String caption, String currentDate, String description, boolean typeTask, boolean complete, String repeat) throws FillingException {
        super(caption, currentDate, description, typeTask, complete, repeat);
    }

    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getCurrentDate();
        return localDate.equals(taskDate) || localDate.isAfter(taskDate);
    }
    public TaskRepeatability getRepeatabilityType() {
        return TaskRepeatability.DAILY;
    }

}

