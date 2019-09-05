import jdk.dynalink.linker.support.SimpleLinkRequest;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.String;
import java.io.*;
import java.io.IOException;

public class Duke {
    //private Storage storage;
    //private TaskList tasks;
    //private Ui ui;

    public static void main(String[] args) {
        ArrayList<Task> tasks;
        Storage file = new Storage();
        boolean isExit = false;

    //String path = "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
    //public Duke(String filePath) {

        Ui ui = new Ui();
        ui.showWelcome();
        //String file = filePath;
        //storage = new Storage(file);
        try {
            tasks = file.LoadFile();
            //tasks = new TaskList(storage.loadFile());
            while(!isExit) {
                ui.readCommand();
                ui.showLine();
                String command = ui.FullCommand.split(" ")[0];
                Command c = Parser.parse(command);
                c.execute(tasks, ui, file);
                isExit = c.isExit();
            }
        } catch (DukeException | ParseException | IOException | NullPointerException e) {
            //ui.showLoadingError();
            if(e instanceof ParseException) {
                //ui.showDateFormatError();
                ui.showLoadingError();
            } else {
                ui.showLoadingError();
            }
        } finally {
            ui.showLine();
        }
    }
}



