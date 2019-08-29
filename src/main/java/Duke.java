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

        ArrayList<String> list = new ArrayList<>();


        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();

            if (inputString.equals ("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (inputString.equals("list")) {
                for (int i = 1; i <= list.size(); i++) {
                    System.out.println(i + ". " + list.get(i-1));
                }
            } else {
                System.out.println("added: " + inputString);
                list.add(inputString);
            }
        }
    }
}
