import java.time.LocalDateTime;

public class Expense {
    private String description;
    private double amount;
    private LocalDateTime time;

    public Expense(String description, double amount, LocalDateTime time) {
        this.description = description;
        this.amount = amount;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}
