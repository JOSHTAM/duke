/**
 * This is an abstract class that states the general characteristics of Commands such as the method
 * execute and the boolean isExit
 */

public abstract class Command {
    /**
     * Executes the command
     * @param tasks The task list that is being passed in to be executed
     * @param ui The User interface functions that can be used
     * @param storage The storage class used to store the file after changes have been made
     * @return the output of the string after the commands have been executed
     * @throws DukeException if there are any errors
     */


    public abstract String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    public abstract boolean isExit();
}
