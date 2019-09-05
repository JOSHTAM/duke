import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Scanner;

public class TaskList extends ArrayList<Task> {

    String absolutePath = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";

    public void saveFile(String absolutePath) {
        //String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
        File file = new File(absolutePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();

            for (int i = 0; i < this.size(); i++) {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(this.get(i).taskType + "-" + this.get(i).getStatusIcon() + "-" + this.get(i).getDesc() + "-" + this.get(i).date + "\n");
                fileWriter.close();
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public ArrayList<Task> alt = new ArrayList<Task>();

    protected ArrayList<Task> LoadFile() throws IOException, ParseException {
        //ArrayList<Task> tasks = new ArrayList<Task>();
        SimpleDateFormat fmt = new SimpleDateFormat("MMM dd HH:mm:ss z yyyy");
        if (new File(absolutePath).exists()) {
            File file = new File(absolutePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] contents = sc.nextLine().split("-");
                if (contents[0].equals("T")) {
                    Todo t = new Todo(contents[2].trim());
                    if (contents[1].equals("\u2713")) {
                        t.isDone = true;
                    } else {
                        t.isDone = false;
                    }
                    alt.add(t);
                } else if (contents[0].equals("D")) {
                    Deadlines d = new Deadlines(contents[2].trim(), fmt.parse(contents[3].substring(3).trim()));
                    if (contents[1].equals("\u2713")) {
                        d.isDone = true;
                    } else {
                        d.isDone = false;
                    }
                    alt.add(d);
                } else {
                    Events e = new Events(contents[2].trim(), fmt.parse(contents[3].substring(3).trim()));
                    if (contents[1].equals("\u2713")) {
                        e.isDone = true;
                    } else {
                        e.isDone = false;
                    }
                    alt.add(e);
                }
            }
        }
        return alt;
    }


    public String get_file_path() {
        return absolutePath;
    }

}

