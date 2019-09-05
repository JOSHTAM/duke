import java.util.Scanner;

public class Ui {

    protected String FullCommand;

    Scanner inputString = new Scanner(System.in);
    private String line = " _________________________________________________________________________________ ";

    String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public String showWelcome() {
        //System.out.println("Hello from\n" + logo);
        //System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
        return "Hello from\n" + logo + "\n" + "Hello! I'm Duke\n" + "What can I do for you\n?";
    }

    public String readCommand() {
        //scanner = new Scanner(System.in);
        //String inputString = scanner.nextLine();
        return inputString.nextLine();
    }

    public String bye() {
         System.out.println("Bye. Hope to see you again soon!");
         return "";
    }

    public String showLine() {
        System.out.println(line);
        return "";
    }

    public String showTaskAdded(String task, int size) {
        String output = "Got it. I've added this task: \n" + task + "\n" + "Now you have " + Integer.toString(size) + " tasks in the list.";
        //        events.toString() + "\n" +
        //        "Now you have " + tasks.size() + " tasks in the list.");
        return output;
    }

    public String showLoadingError() {
        //String output = "Oops! Your file cannot be found";
        System.out.println("Oops! Your file cannot be found");
        return "";
    }

    public String showError(String errorMessage) {
        String output = "";
        if (errorMessage.equals("index error")) {
            output = "Oops! Please enter a valid task index number";
        } else if (errorMessage.equals("unknown")) {
            output = "Oops! Please enter a valid task index number";
        }
        return output;
    }
}
