import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
//import java.util.Arrays;
import  java.io.FileNotFoundException;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;

public class Duke {

    public static ArrayList<Task> loadFile () {
        String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
        Scanner fileInput;
        ArrayList<Task> list = new ArrayList<>();
        File file = new File(path);


        try {
            fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) { //do something
                Boolean stat;
                String line = fileInput.nextLine();
                String[] input = line.split("-");
                String taskType = input[0];
                stat = (input[1].equals("1"));

                if (taskType.equals("D")) {
                    Deadlines deadline = new Deadlines(input[2], input[3]); //info, by
                    deadline.isDone = (stat.equals("\\u2713")) ? true : false;
                    list.add(deadline);
                } else if (taskType.equals("E")) {
                    Events event = new Events(input[2], input[3]); //info, by
                    event.isDone = (stat.equals("\\u2713")) ? true : false;
                    list.add(event);
                } else if (taskType.equals("T")) {
                    Todo todo = new Todo(input[2]); //info, by
                    todo.isDone = (stat.equals("\\u2713")) ? true : false;
                    list.add(todo);
                }


            }
            fileInput.close();
            return list;
        } catch (FileNotFoundException e) {
            System.err.println("File cannot be found");
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

        public static void saveFile (Task t, String taskType, String date) {
            String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
            File file = new File(path);
            try {
                if (taskType.equals("T")) {
                    FileWriter fileWriter = new FileWriter(file, true);
                    fileWriter.write(taskType + "-" + t.getStatusIcon()+ "-" + t.getDesc() + "\n");
                    fileWriter.close();
                }
                else  {
                    FileWriter fileWriter = new FileWriter(file, true);

                    fileWriter.write(taskType + "-" + t.getStatusIcon()+ "-" + t.getDesc() + "-" + date + "\n");
                    fileWriter.close();
                }
            }
            catch (IOException io) {
                System.out.println("File not found:" + io.getMessage());
            }
        }

        public static void update (ArrayList<Task> list) {
            String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
            File file = new File(path);
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.close();

                for (int i = 0; i < list.size(); i++) {
                    fileWriter = new FileWriter(file, true);
                    fileWriter.write(list.get(i).taskType + "-" + list.get(i).getStatusIcon()+ "-" + list.get(i).getDesc() + "-"  + list.get(i).date + "\n");
                    fileWriter.close();
                }
            }
            catch (IOException e) {
                System.err.println("File not found");
            }
        }




    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

            ArrayList<Task> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            list.addAll(Objects.requireNonNull(loadFile()));
        }

            while (true) {
                try {
                    scanner = new Scanner(System.in);
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
                        saveFile(deadlines, "D", inputString.split("/")[1].substring(3));
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
                        saveFile(events, "E", inputString.split("/")[1].substring(3));
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
                        saveFile(todo, "T", "");
                    }
                } else if (inputString.substring(0, 4).equals("done")) {
                    int index = Integer.parseInt(inputString.substring(5));
                    list.get(index - 1).changeStatus(true);
                    System.out.println("Nice! I've marked this task as done: \n" +
                            "[" + list.get(index - 1).getStatusIcon() + "] " + list.get(index - 1).getDesc());
                    update(list);
                } else {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e){
                    System.err.println(e.getMessage());
                }
        }

    }
}
