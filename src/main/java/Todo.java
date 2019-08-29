public class Todo extends Task {


    public Todo (String description) {
        super(description);
        this.taskType = "T";
    }


    @Override
    public String toString() {
        return "[T]" + "[" +super.getStatusIcon()+ "] "+ super.description;
    }
}
