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
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();

            if (inputString.equals ("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (inputString.equals("list")) {
                for (int i = 1; i <= list.size(); i++) {
                    System.out.println(i + ". " + "[" + list.get(i - 1).getStatusIcon() + "] " + list.get(i - 1).getDesc());
                }
            }
            else if (inputString.substring(0,4).equals("done")) {
                int index = Integer.parseInt(inputString.substring(5));
                list.get(index - 1).changeStatus(true);
                System.out.println("Nice! I've marked this task as done: \n" +
                        "[" + list.get(index - 1).getStatusIcon() + "] " + list.get(index - 1).getDesc());
            }
            else {
                System.out.println("added: " + inputString);
                Task task = new Task(inputString);
                list.add(task);
            }
        }
    }
}
