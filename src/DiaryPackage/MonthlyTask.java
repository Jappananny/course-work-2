package DiaryPackage;

import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String caption, String currentDate, String description, boolean typeTask, boolean complete, String repeat) throws FillingException {
        super(caption, currentDate, description, typeTask, complete, repeat);
    }
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getCurrentDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth());
    }

    public TaskRepeatability getRepeatabilityType() {
        return TaskRepeatability.MONTHLY;
    }
}
