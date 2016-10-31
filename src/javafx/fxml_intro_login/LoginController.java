package javafx.fxml_intro_login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * description {@link LoginDemo}'s FXML controller
 * author Melo Chan
 * date 2016/10/31
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private Label buttonStatusText;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        buttonStatusText.setText("Submit, user: " + usernameField.getText());
    }

    @FXML
    private void handlePasswordFieldAction(ActionEvent event) {
        buttonStatusText.setText("Submit password: " + passwordField.getText());
    }
}
