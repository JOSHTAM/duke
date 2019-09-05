import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;

public class Storage {
    String directory = System.getProperty("user.home");
    String fileName = "Save.txt";
    String absolutePath = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
    //public String content;
    //public String path;

    public Storage(String fileContent) throws IOException {

        FileWriter fileWriter = new FileWriter(absolutePath);
        fileWriter.write(fileContent);
        fileWriter.flush();
        fileWriter.close();
    }

    protected ArrayList<Task> LoadFile() throws IOException, ParseException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        if(new File(absolutePath).exists()) {
            File file = new File(absolutePath);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String[] contents = sc.nextLine().split("-");
                if(contents[0].equals("T")) {
                    Todo t = new Todo(contents[2].trim());
                    if(contents[1].equals("\u2713")) {
                        t.isDone = true;
                    } else {
                        t.isDone = false;
                    }
                    tasks.add(t);
                } else if (contents[0].equals("D")) {
                    Deadlines d = new Deadlines(contents[2].trim(), fmt.parse(contents[3].substring(3).trim()));
                    if(contents[1].equals("\u2713")) {
                        d.isDone = true;
                    } else {
                        d.isDone = false;
                    }
                    tasks.add(d);
                } else {
                    Events e = new Events(contents[2].trim(), fmt.parse(contents[3].substring(3).trim()));
                    if(contents[1].equals("\u2713")) {
                        e.isDone = true;
                    } else {
                        e.isDone = false;
                    }
                    tasks.add(e);
                }
            }
        }
        return tasks;
    }

    public String get_file_path() {
        return absolutePath;
    }

}
