package javafx.fxml_intro_login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * description A javafx login page with FXML
 * author Melo Chan
 * date 2016/10/31
 * version 0.0.0.1
 */
public class LoginDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(
                getClass().getResource("page_login.fxml"),
                ResourceBundle.getBundle("javafx.fx")));
        scene.getStylesheets().add("javafx/style.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login (FXML)");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
