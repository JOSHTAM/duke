import java.text.ParseException;
import java.io.IOException;
import java.lang.String;


public class Duke {
    public static void main(String[] args) {

        String absolutePath =  "//Users//joshtamers//Desktop//GitHub//duke//src//main//java//Save";
        Ui ui = new Ui();
        try {

        Storage file = new Storage();
        TaskList tl = new TaskList();
        boolean isExit = false;

        ui.showWelcome();
            tl.alt = tl.LoadFile();
            while(!isExit) {
                ui.readCommand();
                ui.showLine();
                System.out.println("");
                String command = ui.FullCommand;
                Command c = Parser.parse(command);
                c.execute(tl, ui, file);
                ui.showLine();
                isExit = c.isExit();
            }
        } catch (DukeException | ParseException | IOException | NullPointerException e) {
            if(e instanceof ParseException) {
                ui.showLoadingError();
            } else {
                ui.showLoadingError();
            }
        } finally {
            ui.showLine();
        }
    }
}



