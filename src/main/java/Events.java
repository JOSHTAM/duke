import java.util.Date;

public class Events extends Task {

    protected Date at;

    public Events(String description, Date at) {
        super(description);
        this.at = at;
        super.taskType = "E";
        super.date = at;
    }

    @Override
    public String toString() {
        return "[E]"+ "[" +super.getStatusIcon()+ "] " + super.description + " (at: " + at + ")";
    }
}