/**
 * Represents a command that exits the program
 */

public class ExitCommand extends Command {
    /**
     * Executes the command to terminate the program and outputs the description
     * @param tasks The task list that is being passed in to be executed
     * @param ui The User interface functions that can be used
     * @param storage The storage class used to store the file after changes have been made
     * @return the description that terminates the program
     * @throws DukeException
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        return ui.bye();
    }

    /**
     * Boolean to be set as false as it is not an exit Command
     * @return
     */
    public boolean isExit() {
        return true;
    }
}
