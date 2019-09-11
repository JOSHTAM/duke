/**
 * Represents a command that deletes an item from the task list
 */


public class DeleteCommand extends Command {
    private int index;

    /**
     * Creates a new command object based on the input index
     * @param index
     */
    public DeleteCommand (int index) {
        this.index = index;
    }


    /*
    int index = Integer.parseInt(inputString.substring(7));
            list.get(index - 1).changeStatus(false);
            System.out.println("Noted. I've removed this task: \n" +
                    list.get(index - 1).toString() +
            "\n" + "Now you have " + (list.size()-1) + " tasks in the list.");
            list.remove(index -1);
    update(list);
*/

    /**
     * Executes the command and deletes the item at that index of the list and stores the new list
     * @param tasks The task list that is being passed in to be executed
     * @param ui The User interface functions that can be used
     * @param storage The storage class used to store the file after changes have been made
     * @return the description after the command has been executed
     * @throws DukeException
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        //if(this.index >= tasks.size()) throw new DukeException("index error");
        tasks.alt.get(index - 1).changeStatus(false);
        String output = "Noted. I've removed this task: \n" +
                tasks.alt.get(index - 1).toString() +
                "\n" + "Now you have " + (tasks.alt.size()-1) + " tasks in the list.";
        System.out.println("Noted. I've removed this task: \n" +
                tasks.alt.get(index - 1).toString() +
                "\n" + "Now you have " + (tasks.alt.size()-1) + " tasks in the list.");
        tasks.alt.remove(index - 1);
        //tasks.saveFile(Task t, String taskType, String date);
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
