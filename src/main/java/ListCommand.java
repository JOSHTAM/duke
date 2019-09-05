
public class ListCommand extends Command{
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (tasks.isEmpty()) throw new DukeException("List is empty");
        String output = "";

        for (int i = 1; i <= tasks.size(); i++) {
            //System.out.println(i + "." + tasks.get(i - 1).toString());
            output += i + "." + tasks.get(i-1).toString() + "\n";
        }
        return output;
    }



    @Override
    public boolean isExit() {
        return false;
    }
}
