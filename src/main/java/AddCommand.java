import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCommand extends Command {

    private String description;
    private String taskType;
    private Date datetime;

    public AddCommand(String taskType, String description) {
        this.description = description;
        this.taskType = taskType;
    }

    public AddCommand(String taskType, String description, Date datetime) {
        this.description = description;
        this.taskType = taskType;
        this.datetime = datetime;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskType.equals("todo")) tasks.add(new Todo(description));
        else if (taskType.equals("deadline")) tasks.add(new Deadlines(description, datetime));
        else if (taskType.equals("event")) tasks.add(new Events(description, datetime));
        else throw new DukeException("add error");
        tasks.saveFile(storage.get_file_path());
        return ui.showTaskAdded(tasks.get(tasks.size()-1).toString(), tasks.size());
    }

    public boolean isExit() {
        return false;
    }
}
