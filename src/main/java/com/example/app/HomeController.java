package com.example.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageButtonHome;

    @FXML
    void initialize() {
        assert imageButtonHome != null : "fx:id=\"imageButtonHome\" was not injected: check your FXML file 'app.fxml'.";

    }

}



