package javafx.fxml_intro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * description A simple javafx demo with FXML
 * author Melo Chan
 * date 2016/10/31
 * version 0.0.0.1
 */
public class SimpleDemoWithFXML extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("page_simple.fxml"))));
        primaryStage.setTitle("Simple (FXML)");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
