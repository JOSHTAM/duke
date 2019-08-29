public class Deadlines extends Task {

    protected String by;

    public Deadlines(String description, String by) {
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