package com.example.app;

import com.example.app.amimation.Shake;
import com.example.app.config.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Node;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button JoinButton;

    @FXML
    private Button LogInButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    void initialize() {

        JoinButton.setOnAction(event -> {
            String loginText = LoginField.getText().trim();
            String passwordText = PasswordField.getText().trim();

            if (!loginText.equals("") && !passwordText.equals("")){
                loginUser(loginText, passwordText);
            }else {
                System.out.println("Please fill in the field");
            }
        });

        LogInButton.setOnAction(event -> {
            LogInButton.getScene().getWindow().hide();

            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("sign_app.fxml"));
            try {
                Loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = Loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter>=1){
            System.out.println("Success");

            JoinButton.getScene().getWindow().hide();

            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("app.fxml"));
            try {
                Loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = Loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        }else {
            Shake userLoginAnimation = new Shake(LoginField);
            Shake userPasswordAnimation = new Shake(PasswordField);
            userLoginAnimation.playAnim();
            userPasswordAnimation.playAnim();
        }
    }

}

