package DiaryPackage;
import java.time.LocalDate;

public class SingleTask extends Task{

    public SingleTask(String caption, String currentDate, String description, boolean typeTask, boolean complete, String repeat) throws FillingException {
        super(caption, currentDate, description, typeTask, complete, repeat);
    }

    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getCurrentDate());
    }
    public TaskRepeatability getRepeatabilityType() {
        return TaskRepeatability.SINGLE;
    }
}
