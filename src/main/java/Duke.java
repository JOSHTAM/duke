import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        ArrayList<Task> list = new ArrayList<>();


            while (true) {
                try {
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();

                if (inputString.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (inputString.equals("list")) {
                    for (int i = 1; i <= list.size(); i++) {
                        System.out.println(i + "." + list.get(i - 1).toString());
                    }
                } else if (inputString.startsWith("deadline")) {
                    if(inputString.equals("deadline")){
                        throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                    }
                    else {
                        int index = inputString.indexOf("/by");
                        String info = inputString.substring(9, index);
                        Deadlines deadlines = new Deadlines(info, inputString.split("/")[1].substring(3));
                        list.add(deadlines);
                        System.out.println("Got it. I've added this task: \n" +
                                deadlines.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                    }
                } else if (inputString.startsWith("event")) {
                    if(inputString.equals("event")){
                        throw new DukeException("OOPS!!! The description of a event cannot be empty.");
                    }
                    else {
                        int index = inputString.indexOf("/at");
                        String info = inputString.substring(6, index);
                        Events events = new Events(info, inputString.split("/")[1].substring(3));
                        list.add(events);
                        System.out.println("Got it. I've added this task: \n" +
                                events.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                    }
                } else if (inputString.startsWith("todo")) {
                    if(inputString.equals("todo")){
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    else {
                        Todo todo = new Todo(inputString.substring(5));
                        list.add(todo);
                        System.out.println("Got it. I've added this task: \n" +
                                todo.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                    }
                } else if (inputString.substring(0, 4).equals("done")) {
                    int index = Integer.parseInt(inputString.substring(5));
                    list.get(index - 1).changeStatus(true);
                    System.out.println("Nice! I've marked this task as done: \n" +
                            "[" + list.get(index - 1).getStatusIcon() + "] " + list.get(index - 1).getDesc());
                } else {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e){
                    System.err.println(e.getMessage());
                }
        }

    }
}
