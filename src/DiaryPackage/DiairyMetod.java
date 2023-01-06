package DiaryPackage;

import java.time.LocalDate;
import java.util.Scanner;

public interface DiairyMetod {

    void addTask(Task task) throws FillingException;

    void taskFromUser(TaskServise taskMap, Scanner scanner) throws FillingException;

    void printAllTasks();

}
