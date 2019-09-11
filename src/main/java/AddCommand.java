import java.text.SimpleDateFormat;
/**
 * Represents a command that adds an item to the task list
 */


import java.util.Date;

public class AddCommand extends Command {

    private String description;
    private String taskType;
    private Date datetime;

    /**
     * Creates a new object with the input type (todo) and the description
      * @param taskType gets the task type
     * @param description gets the description
     */
    public AddCommand(String taskType, String description) {
        this.description = description;
        this.taskType = taskType;
    }

    /**
     * Creates a new object with the input type (deadlines/events) and their descriptions
     * @param taskType
     * @param description
     * @param datetime
     */
    public AddCommand(String taskType, String description, Date datetime) {
        this.description = description;
        this.taskType = taskType;
        this.datetime = datetime;
    }

    /**
     * Executes the Command and adds the type of task to the list to be stored
     * @param tasks The task list that is being passed in to be executed
     * @param ui The User interface functions that can be used
     * @param storage The storage class used to store the file after changes have been made
     * @return the description after the command has been executed
     * @throws DukeException
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskType.equals("todo")) tasks.add(new Todo(description));
        else if (taskType.equals("deadline")) tasks.add(new Deadlines(description, datetime));
        else if (taskType.equals("event")) tasks.add(new Events(description, datetime));
        else throw new DukeException("add error");
        tasks.saveFile(tasks.get_file_path());
        return ui.showTaskAdded(tasks.get(tasks.size()-1).toString(), tasks.size());
    }

    /**
     * Boolean to be set as false as it is not an exit Command
     * @return
     */
    public boolean isExit() {
        return false;
    }
}
