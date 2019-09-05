public class DoneCommand extends Command {
    private int index;
    public DoneCommand(int index) {
        this.index = index;
    }


    //int index = Integer.parseInt(inputString.substring(5));
    //                tasks.get(index - 1).changeStatus(true);
    //                System.out.println("Nice! I've marked this task as done: \n" +
    //                        "[" + tasks.get(index - 1).getStatusIcon() + "] " + tasks.get(index - 1).getDesc());
    //update(tasks);



    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (this.index >= tasks.size()) throw new DukeException("index error");
        tasks.get(index - 1).changeStatus(true);
        String output = "Nice! I've marked this task as done: \n" +
                "[" + tasks.get(index - 1).getStatusIcon() + "] " + tasks.get(index - 1).getDesc();
        return output;
        }

        public boolean isExit() {
        return false;
        }
}
