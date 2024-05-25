import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LifeLog {
    private List<DailyLog> dailyLogs;

    public LifeLog() {
        this.dailyLogs = new ArrayList<>();
    }

    public void addDailyLog(DailyLog dailyLog) {
        dailyLogs.add(dailyLog);
    }

    public DailyLog getDailyLog(LocalDate date) {
        for (DailyLog dailyLog : dailyLogs) {
            if (dailyLog.getDate().equals(date)) {
                return dailyLog;
            }
        }
        return null;
    }

    public String generateOverallSummary() {
        StringBuilder summary = new StringBuilder("Overall Summary:\n");
        for (DailyLog dailyLog : dailyLogs) {
            summary.append(dailyLog.generateSummary()).append("\n");
        }
        return summary.toString();
    }
}
