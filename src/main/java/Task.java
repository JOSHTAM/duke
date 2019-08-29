import java.util.Date;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;
    protected Date date;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Boolean changeStatus(Boolean stat) {
        this.isDone = stat;
        return this.isDone;
    }

    public String getDesc() {
        return description;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //...
}
