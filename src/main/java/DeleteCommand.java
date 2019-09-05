public class DeleteCommand extends Command {
    private int index;
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


    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if(this.index >= tasks.size()) throw new DukeException("index error");
        tasks.get(index - 1).changeStatus(false);
        String output = "Noted. I've removed this task: \n" +
                tasks.get(index - 1).toString() +
                "\n" + "Now you have " + (tasks.size()-1) + " tasks in the list.";
        tasks.remove(index - 1);
        //tasks.saveFile(Task t, String taskType, String date);
        return output;
    }

    public boolean isExit() {
        return false;
    }
}
