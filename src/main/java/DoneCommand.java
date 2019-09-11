/**
 * Represents a command that marks the task as done in the task list
 */

public class DoneCommand extends Command {
    private int index;

    /**
     * Creates a new object with the input index
     * @param index
     */
    public DoneCommand(int index) {
        this.index = index;
    }


    //int index = Integer.parseInt(inputString.substring(5));
    //                tasks.get(index - 1).changeStatus(true);
    //                System.out.println("Nice! I've marked this task as done: \n" +
    //                        "[" + tasks.get(index - 1).getStatusIcon() + "] " + tasks.get(index - 1).getDesc());
    //update(tasks);


    /**
     * Executes the command and marks the task at the given index done and stores the new list
     * @param tasks The task list that is being passed in to be executed
     * @param ui The User interface functions that can be used
     * @param storage The storage class used to store the file after changes have been made
     * @return returns the description after the command has been executed
     * @throws DukeException
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        //if (this.index >= tasks.alt.size()) throw new DukeException("index error");
        tasks.alt.get(index - 1).changeStatus(true);
        String output = "Nice! I've marked this task as done: \n" +
                "[" + tasks.alt.get(index - 1).getStatusIcon() + "] " + tasks.alt.get(index - 1).getDesc();
        System.out.println("Nice! I've marked this task as done: \n" +
                "[" + tasks.alt.get(index - 1).getStatusIcon() + "] " + tasks.alt.get(index - 1).getDesc());

        return output;
        }
    /**
     * Boolean to be set as false as it is not an exit Command
     * @return
     */
        public boolean isExit() {
        return false;
        }
}
