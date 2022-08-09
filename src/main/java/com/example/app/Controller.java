package com.example.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.app.config.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginField;

    @FXML
    private TextField NumberPhoneField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignLogInButton;

    @FXML
    private TextField UserNameField;

    @FXML
    void initialize() {


        SignLogInButton.setOnAction(event -> {
            
            signUpNewUser();


        });
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String User_name = UserNameField.getText();
        String Number_phone = NumberPhoneField.getText();
        String Login = LoginField.getText();
        String Password = PasswordField.getText();

        User user = new User(User_name, Number_phone, Login, Password);

        dbHandler.signUOUser(user);
    }

}
