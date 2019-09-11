import java.text.ParseException;
import java.io.IOException;
import java.lang.String;

/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
*/

//public class Duke extends Application {
public class Duke {

    /*

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;


    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.jpg"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.jpg"));


    @Override
    public void start(Stage stage) {
        //Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        //helloWorld.setFont(new Font("Arial", 50));
        //helloWorld.setTextFill(Color.web("0076a3"));
        //Scene scene = new Scene(helloWorld); // Setting the scene to be our Label
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);


        sendButton.setOnMouseClicked((event) -> {
            //dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            //userInput.clear();
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            //dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            //userInput.clear();
            handleUserInput();
        });

        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        scene = new Scene(mainLayout);

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }


    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */

    /*
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    /**
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */

    /*
    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                new DialogBox(userText, new ImageView(user)),
                new DialogBox(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */


    /*
    private String getResponse(String input) {
        return "Duke heard: " + input;
    }
    */


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



