import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 * Represents a parser to make sense of the user input and translates it into commands for Duke
 */
public class Parser {

    /**
     * Takes in the user input and makes sense of it
     * @param inputString takes in the input String
     * @return Duke commands based on the user input
     * @throws DukeException if there is any error
     */
    public static Command parse(String inputString) throws DukeException {
        if (inputString.isBlank()) throw new DukeException("Input is blank");
        try {
            //while (true) {
                if (inputString.equals("bye")) {
                   return new ExitCommand();
                } else if (inputString.equals("list")) {
                    //for (int i = 1; i <= tasks.size(); i++) {
                    //    System.out.println(i + "." + tasks.get(i - 1).toString());
                    // }
                    return new ListCommand();
                } else if (inputString.startsWith("deadline")) {
                    if (inputString.equals("deadline")) {
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                    } else {
                        int index = inputString.indexOf("/by");
                        String description = inputString.substring(9, index);
                        //String date = inputString.split("/")[1].substring(3);
                        //Deadlines deadlines = new Deadlines(info, inputString.split("/")[1].substring(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
                        //Deadlines deadlines = new Deadlines(description, dateFormat.parse(inputString.split("/")[1].substring(3)));
                        //tasks.add(deadlines);
                        //System.out.println("Got it. I've added this task: \n" +
                        //        deadlines.toString() + "\n" +
                        //        "Now you have " + tasks.size() + " tasks in the list.");
                        //saveFile(deadlines, "D", inputString.split("/")[1].substring(3));
                        return new AddCommand("deadline", description, dateFormat.parse(inputString.split("/")[1].substring(3)));
                    }
                } else if (inputString.startsWith("event")) {
                    if (inputString.equals("event")) {
                        throw new DukeException("OOPS!!! The description of a event cannot be empty.");
                    } else {
                        int index = inputString.indexOf("/at");
                        String description = inputString.substring(6, index);
                        //String date = inputString.split("/")[1].substring(3);
                        //Events events = new Events(info, inputString.split("/")[1].substring(3));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
                        //Events events = new Events(description, dateFormat.parse(inputString.split("/")[1].substring(3)));
                        //tasks.add(events);
                        //System.out.println("Got it. I've added this task: \n" +
                        //        events.toString() + "\n" +
                        //        "Now you have " + tasks.size() + " tasks in the list.");
                        //saveFile(events, "E", inputString.split("/")[1].substring(3));
                        return new AddCommand("event", description, dateFormat.parse(inputString.split("/")[1].substring(3)));
                    }
                } else if (inputString.startsWith("todo")) {
                    if (inputString.equals("todo")) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    } else {
                        String description = inputString.substring(5);
                        //Todo todo = new Todo(inputString.substring(5));
                        //tasks.add(todo);
                        //System.out.println("Got it. I've added this task: \n" +
                        //        todo.toString() + "\n" +
                        //       "Now you have " + tasks.size() + " tasks in the list.");
                        //saveFile(todo, "T", "");
                        return new AddCommand("todo", description);
                    }
                } else if (inputString.substring(0, 4).equals("done")) {

                    int index = Integer.parseInt(inputString.substring(5));
                    //tasks.get(index - 1).changeStatus(true);
                    //System.out.println("Nice! I've marked this task as done: \n" +
                    //        "[" + tasks.get(index - 1).getStatusIcon() + "] " + tasks.get(index - 1).getDesc());
                    //update(tasks);
                    return new DoneCommand(index);
                } else if (inputString.substring(0, 6).equals("delete")) {
                    int index = Integer.parseInt(inputString.substring(7));
                    //tasks.get(index - 1).changeStatus(false);
                    //System.out.println("Noted. I've removed this task: \n" +
                    //        list.get(index - 1).toString() +
                    //        "\n" + "Now you have " + (list.size()-1) + " tasks in the list.");
                    //list.remove(index -1);
                    //update(list);
                    return new DeleteCommand(index);
                } else if (inputString.substring(0, 4).equals("find")) {
                    String keyword = inputString.substring(5);
                    //System.out.println("Here are the matching tasks in your list:");
                    //find(tasks, keyword);
                    return new FindCommand(keyword);
                } else {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
        }
        catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        throw new DukeException("unknown");
    }
        //} catch (DukeException | ParseException e) {
            //System.err.println(e.getMessage());
}
