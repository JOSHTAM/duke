import java.util.Date;

public class Deadlines extends Task {

    //protected String by;
    protected Date by;

    public Deadlines(String description, Date by) {
        super(description);
        this.by = by;
        this.taskType = "D";
        super.date = by;
    }

    @Override
    public String toString() {
        return "[D]"+ "[" +super.getStatusIcon()+ "] " + super.description + " (by: " + by + ")";
    }
}
