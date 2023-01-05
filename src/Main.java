import DiaryPackage.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;



public class Main {
    public final static TaskServise TASK_MAP = new TaskServise();
    public static void main(String[] args) throws FillingException {
        System.out.println(
                " \uD83C\uDD5C\uD83C\uDD50\uD83C\uDD53\uD83C\uDD54 \uD83C\uDD51\uD83C\uDD68 \uD83C\uDD59\uD83C\uDD50\uD83C\uDD5F\uD83C\uDD5F\uD83C\uDD50\uD83C\uDD5D\uD83C\uDD50\uD83C\uDD5D\uD83C\uDD5D\uD83C\uDD68 (➋⓿➋➋)");
        String  menuChoise = "0";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите пункт меню:");
        while (!menuChoise.equals("4")) {
            Messages.menu(scanner);
            menuChoise = scanner.nextLine();
            switch (menuChoise) {
                case "1":
                    TASK_MAP.taskFromUser(TASK_MAP,scanner);
                    break;
                case "2":
                    TaskServise.removeTasks(scanner);
                    break;
                case "3":
                    TaskServise.printTaskForDate(scanner);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Ой что-то пошло не так!");
                }
            }
        }
    }






