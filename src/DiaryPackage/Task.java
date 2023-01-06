package DiaryPackage;
import lombok.Getter;
import lombok.Setter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public abstract class Task implements Repeatable {
    private final String caption;
    private String description;
    private final String typeTask;
    private String complete;
    private LocalDate currentDate;
    private final Integer id;
    private String repeat;
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    public Task(String caption, String currentDate, String description, boolean typeTask, boolean complete, String repeat)
            throws FillingException {
        if (caption.length() == 0 && caption == null){
            throw new FillingException("Не заполнено поле");
        } else {
            this.caption = caption;
        }
        if (currentDate.compareTo(String.valueOf(LocalDate.now()))<0) {
            throw new DateTimeException("Прошедшая дата не допускается");
        } else {
                DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy_MM_dd");
            this.currentDate = LocalDate.parse(currentDate,formattedDate);
        }
        this.description = description;
        this.typeTask = typeTask ? "Рабочая задача" : "Личная задача";
        this.complete = complete ? "Задача выполнена" : "Задача не выполнена";
        this.repeat = repeat;
        this.id = COUNTER.getAndIncrement();
    }
    @Override
    public void markCompleted() {
        this.complete = String.valueOf(true);
    }

    @Override
    public String toString() {
        return "Задача{" +
                " ID:" + id +
                ", Дата создания:" + currentDate +
                ", Тип:'" + typeTask + '\'' +
                ", Название:'" + caption + '\'' +
                ", Описание:'" + description + '\'' +
                ", Повторяемость:" + repeat +
                ", Выполнение:'" + complete + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(caption, task.caption) && Objects.equals(description, task.description)
                && Objects.equals(typeTask, task.typeTask) && Objects.equals(complete, task.complete) &&
                Objects.equals(currentDate, task.currentDate) && Objects.equals(repeat, task.repeat);
    }
    @Override
    public int hashCode() {
        return Objects.hash(caption, description, typeTask, complete, currentDate, id, repeat);
    }
}
