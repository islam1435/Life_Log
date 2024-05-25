import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyLog {
    private LocalDate date;
    private List<Activity> activities;
    private List<Expense> expenses;

    public DailyLog(LocalDate date) {
        this.date = date;
        this.activities = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String generateSummary() {
        StringBuilder summary = new StringBuilder("Summary for " + date + ":\n");

        summary.append("Activities:\n");
        for (Activity activity : activities) {
            summary.append(activity).append("\n");
        }

        summary.append("Expenses:\n");
        double totalExpense = 0;
        for (Expense expense : expenses) {
            summary.append(expense).append("\n");
            totalExpense += expense.getAmount();
        }
        summary.append("Total Expenses: ").append(totalExpense).append("\n");

        return summary.toString();
    }
}
