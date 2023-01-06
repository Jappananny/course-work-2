package DiaryPackage;

import java.util.Scanner;

public class Messages {

    public static void menu(Scanner scanner) {
        System.out.println("\n[1] Добавить новую задачу");
        System.out.println("[2] Удалить задачу");
        System.out.println("[3] Посмотреть список задач");
        System.out.print("Пожалуйста, сделайте выбор [1-3]: ");
    }
}