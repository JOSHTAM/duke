
public class ListCommand extends Command{
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        //if (tasks.alt.isEmpty()) throw new DukeException("List is empty");
        String output = "";
        System.out.println("Here are the tasks in your list: ");
        for (int i = 1; i <= tasks.alt.size(); i++) {
            System.out.println( i + "." + tasks.alt.get(i - 1).toString());
            //output += i + "." + tasks.alt.get(i-1).toString() + "\n";
        }
        return output;
    }



    @Override
    public boolean isExit() {
        return false;
    }
}
