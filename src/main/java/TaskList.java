import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;

public class TaskList extends ArrayList<Task> {



    public void saveFile(String path) {
            //String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
            File file = new File(path);
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.close();

            for (int i = 0; i < this.size(); i++) {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(this.get(i).taskType + "-" + this.get(i).getStatusIcon()+ "-" + this.get(i).getDesc() + "-"  + this.get(i).date + "\n");
                fileWriter.close();
                }
            }
            catch (IOException e) {
                System.err.println("File not found");
            }
        }


    public TaskList(String fileInput) {
        if (fileInput.isBlank()) {
            return;
        }
        try {
            while (fileInput.hasNext()) {
                Boolean stat;
                String line = fileInput.nextLine();         //creates a string to store the next line
                String[] input = line.split("-");       //splits the line into parts and stores them into a string array
                String taskType = input[0];             //creates a string to store input[0] which is called taskType
                stat = (input[1].equals("1"));          //changes the boolean stat value to TRUE if input 1 value is equals to 1/ false otherwise

                if (taskType.equals("D")) {             //if input is a D, create a new entry for Deadline, and stores it into the list which is of type "Task"
                    //Deadlines deadline = new Deadlines(input[2], input[3]);         //
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
                    Deadlines deadline = new Deadlines(input[2], dateFormat.parse(input[3]));
                    deadline.isDone = (stat.equals("\\u2713")) ? true : false;
                    //tasks.add(deadline);
                    this.add(deadline);
                } else if (taskType.equals("E")) {
                    //Events event = new Events(input[2], input[3]);          //
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
                    Events event = new Events(input[2], dateFormat.parse(input[3]));
                    event.isDone = (stat.equals("\\u2713")) ? true : false;
                    //tasks.add(event);
                    this.add(event);
                } else if (taskType.equals("T")) {
                    Todo todo = new Todo(input[2]);         //dosen't require SimpleDateFormatter
                    todo.isDone = (stat.equals("\\u2713")) ? true : false;
                    //tasks.add(todo);
                    this.add(todo);
                }
            }
            //fileInput.close();
            //return tasks;
        } catch (ParseException e) {
            System.err.println("File cannot be found");
            //return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Opps! Array out of bounds");
        }

    }
}





/*
    public String TaskList() {
        public static void update (ArrayList<Task> tasks) {
            String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
            File file = new File(path);
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.close();

                for (int i = 0; i < tasks.size(); i++) {
                    fileWriter = new FileWriter(file, true);
                    fileWriter.write(tasks.get(i).taskType + "-" + tasks.get(i).getStatusIcon()+ "-" + tasks.get(i).getDesc() + "-"  + tasks.get(i).date + "\n");
                    fileWriter.close();
                }
            }
            catch (IOException e) {
                System.err.println("File not found");
            }
        }
    }




*/

    /*
    public static void saveFile(Task t, String taskType, String date) {            //creates a function to save the text file
        String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
        File file = new File(path);
        try {
            if (taskType.equals("T")) {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(taskType + "-" + t.getStatusIcon() + "-" + t.getDesc() + "\n");
                fileWriter.close();
            } else {
                FileWriter fileWriter = new FileWriter(file, true);

                fileWriter.write(taskType + "-" + t.getStatusIcon() + "-" + t.getDesc() + "-" + date + "\n");
                fileWriter.close();
            }
        } catch (IOException io) {
            System.out.println("File not found:" + io.getMessage());
        }
    }

    */

/*
    ArrayList<Task> tasks = new ArrayList<>();
    //Scanner scanner = new Scanner(System.in);
    String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
    File file = new File(path);
    //try {
    Scanner scanner = new Scanner(file);            //new line


        if (scanner.hasNext()) {
                tasks.addAll(Objects.requireNonNull(loadFile()));
                }

        */