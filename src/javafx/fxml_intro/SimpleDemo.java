package javafx.fxml_intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * description A simple javafx demo with pure java code
 * author Melo Chan
 * date 2016/10/31
 * version 0.0.0.1
 */
public class SimpleDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setTop(new Label("Title"));
        root.setCenter(new Label("Content"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Simple");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
