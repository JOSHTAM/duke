import java.util.Date;

public class Task {
    protected String description;
    protected boolean isDone;           //creates a boolean called "isDone" to track whether the task is done or not
    protected String taskType;          //creates a String called taskType to track whether the task is a todo/deadline or a event
    //protected String date;              //creates a String called date - Level 8
    protected Date date;

    public Task(String description) {
        this.description = description;
        this.isDone = false;            //by default sets the boolean "isDone" to a false
    }

    public Boolean changeStatus(Boolean stat) {
        this.isDone = stat;
        return this.isDone;             //returns the boolean "isDone" based on the status of the tick
    }

    public String getDesc() {
        return description;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    //...
}
