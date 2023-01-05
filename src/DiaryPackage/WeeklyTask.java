package DiaryPackage;

import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String caption, String currentDate, String description, boolean typeTask, boolean complete, String repeat) throws FillingException {
        super(caption, currentDate, description, typeTask, complete, repeat);
    }
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getCurrentDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate)
                && localDate.getDayOfWeek().equals(taskDate.getDayOfWeek()));
    }
    public TaskRepeatability getRepeatabilityType() {
        return TaskRepeatability.WEEKLY;
    }
}
