import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LifeLogApp {
    private static LifeLog lifeLog = new LifeLog();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("LifeLog Menu:");
            System.out.println("1. Add Activity");
            System.out.println("2. Add Expense");
            System.out.println("3. View Daily Summary");
            System.out.println("4. View Overall Summary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addActivity(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    viewDailySummary(scanner);
                    break;
                case 4:
                    viewOverallSummary();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addActivity(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter start time (YYYY-MM-DD): ");
        LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());

        System.out.print("Enter end time (YYYY-MM-DD): ");
        LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());

        DailyLog dailyLog = lifeLog.getDailyLog(date);
        if (dailyLog == null) {
            dailyLog = new DailyLog(date);
            lifeLog.addDailyLog(dailyLog);
        }

        dailyLog.addActivity(new Activity(description, startTime, endTime));
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter time (YYYY-MM-DD): ");
        LocalDateTime time = LocalDateTime.parse(scanner.nextLine());

        DailyLog dailyLog = lifeLog.getDailyLog(date);
        if (dailyLog == null) {
            dailyLog = new DailyLog(date);
            lifeLog.addDailyLog(dailyLog);
        }

        dailyLog.addExpense(new Expense(description, amount, time));
    }

    private static void viewDailySummary(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        DailyLog dailyLog = lifeLog.getDailyLog(date);
        if (dailyLog != null) {
            System.out.println(dailyLog.generateSummary());
        } else {
            System.out.println("No entries for this date.");
        }
    }

    private static void viewOverallSummary() {
        System.out.println(lifeLog.generateOverallSummary());
    }
}
