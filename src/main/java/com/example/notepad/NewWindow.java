package com.example.notepad;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWindow {
    public NewWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Notepad.class.getResource("notepad-view.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("notepad.png"))));
        stage.setTitle("My Notepad-New Window");
        stage.setScene(scene);
        stage.show();
    }
}
