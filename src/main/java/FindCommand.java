import java.util.ArrayList;
import java.io.*;

public class FindCommand extends Command {
    private String keyword;
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }


    //public static void find (ArrayList<Task> tasks, String keyword) {
        //ArrayList<Task> tempArray = new ArrayList<>();
        //for (Task task : tasks) {
        //    if (task.toString().contains(keyword)) {
        //        tempArray.add(task);
        //    }
        // }
        ////System.out.println(tempArray.size());
        //for (int i = 0; i < tempArray.size(); i++) {
        //    System.out.println((i+1) + "." + tempArray.get(i).toString());
        //}
        //tempArray.clear();
    //}


    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        //System.out.println("Here are the matching tasks in your list:");
        if (!tasks.contains(keyword)) throw new DukeException("Could not be found.");
        String output = "";
        ArrayList<Task> tempArray = new ArrayList<>();
        for (Task task : tasks) {
            if (task.toString().contains(keyword)) {
                tempArray.add(task);
            }
        }
        //System.out.println(tempArray.size());
        for (int i = 0; i < tempArray.size(); i++) {
            //System.out.println((i+1) + "." + tempArray.get(i).toString());
            output += (i+1) + "." +tempArray.get(i).toString() + "\n";
        }
        tempArray.clear();
        //String output =
        return output;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
