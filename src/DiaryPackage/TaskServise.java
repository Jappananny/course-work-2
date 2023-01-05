package DiaryPackage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class TaskServise implements DiairyMetod{
    public static final Map<Integer, Task> taskMap = new HashMap<>();
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy_MM_dd");
    public static Collection<Task> getTaskOfDay(LocalDate date) {
        Set<Task> tasksForDate = new HashSet<>();
        for (Task task:taskMap.values()){
            if (task.appearsIn(date)){
                tasksForDate.add(task);
            }
        }
        return tasksForDate;
    }
    @Override
    public void addTask(Task task) throws FillingException {
        if (taskMap.containsKey(task.getId())) {
            throw new RuntimeException("Задание с этим ID уже есть!");
        }
        this.taskMap.put(task.getId(),task);
    }
    public Collection<Task>getAllTasks() {
        return this.taskMap.values();
    }
    @Override
    public void taskFromUser(TaskServise taskMap,Scanner scanner) throws FillingException {
        try {
            System.out.println("\nПожалуйста, введите следующие данные, чтобы добавить задачу: ");
            System.out.print("Название задачи: ");
            String caption = scanner.nextLine();
            System.out.print("Дата создания задачи: " +
                    "\nВ формате [год_месяц_день]" +
                    "\nПоле для ввода: ");
            String currentDate = scanner.nextLine();
            System.out.print("Описание задачи: ");
            String description = scanner.nextLine();
            System.out.print("Выбор типа задачи: " +
                    "\ntrue - 'Рабочая задача'" +
                    "\nfalse - 'Личная задача'" +
                    "\nПоле для ввода: ");
            boolean typeTask = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Выполнение задачи: " +
                    "\ntrue - 'Задача выполнена'" +
                    "\nfalse - 'Задача не выполнена'" +
                    "\nПоле для ввода: ");
            boolean complete = Boolean.parseBoolean(scanner.nextLine());
            Repeat repeatTask = readRepeatTask(scanner);
            Task task = switch (repeatTask) {
                case SINGLE -> new SingleTask(caption, currentDate, description, typeTask,complete, repeatTask.getRepeat());
                case DAILY -> new DailyTask(caption, currentDate, description, typeTask,complete, repeatTask.getRepeat());
                case WEEKLY -> new WeeklyTask(caption, currentDate, description, typeTask,complete, repeatTask.getRepeat());
                case MONTHLY -> new MonthlyTask(caption, currentDate, description, typeTask,complete, repeatTask.getRepeat());
                case YEARLY -> new YearlyTask(caption, currentDate, description, typeTask,complete, repeatTask.getRepeat());
            };
            taskMap.addTask(task);
            System.out.println("Задача добавлена");
        } catch (FillingException e) {
            throw new FillingException("Не заполнено поле");
            }
    }
    private static String localizeRepeatabilityTask(Repeat repeatTask) {
        return switch (repeatTask) {
            case SINGLE -> "Однократная задача";
            case DAILY -> "Ежедневная задача";
            case WEEKLY -> "Еженедельная задача";
            case MONTHLY -> "Ежемесячная задача";
            case YEARLY -> "Ежегодная задача";
        };
    }
    private static Repeat readRepeatTask(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Выберите тип повторяемости: ");
                for (Repeat repeatTask : Repeat.values()) {
                    System.out.println(repeatTask.ordinal()+ " - " + localizeRepeatabilityTask(repeatTask));
                }
                System.out.println("Введите тип повторяемости задачи: ");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return Repeat.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный тип повторяемости задачи ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Тип повторяемости не найден ");
            }
        }
    }
    public static void removeTasks(Scanner scanner) throws NumberFormatException {
        System.out.println("Показать все задачи: ");
        for (Task task : taskMap.values()) {
            System.out.printf("%d. %s [%s](%s)%n", task.getId(), task.getCaption(), task.getTypeTask(),
                    task.getRepeat());
        }
        while (true) {
            try {
                System.out.println("Выбрать задачу для удаления: ");
                String idLine = scanner.nextLine();
                int id = Integer.parseInt(idLine);
                taskMap.remove(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный id задачи ");
            }
        }
    }
    public static void printTaskForDate(Scanner scanner) {
        LocalDate localDate = readDate(scanner);
        Collection<Task> taskForDate = TaskServise.getTaskOfDay(localDate);
        System.out.println("Задачи на " + localDate.format(DATE_FORMAT));
        for (Task task : taskForDate) {
            System.out.printf("[%s]%s: %s (%s)%n",
                    task.getId(),
                    task.getCurrentDate(),
                    task.getCaption(),
                    task.getDescription());
        }
    }

    public static LocalDate readDate(Scanner scanner) {
        while (true) {
            try {
                System.out.printf("Введите дату задачи в формате [год_месяц_день]: ");
                String dateLine = scanner.nextLine();
                return LocalDate.parse(dateLine, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Введена дата в неверном формате");
            }

        }

    }
    @Override
    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            System.out.println(entry.getValue());
            } if (taskMap.entrySet().isEmpty()){
            System.out.println("Никаких задач для показа");
            }
        }

    }


