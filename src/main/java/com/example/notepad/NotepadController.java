package com.example.notepad;


import javafx.application.Platform;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.Printer;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class NotepadController  {

    @FXML
    private TextArea textArea;

    @FXML
    void handleAction(ActionEvent e) throws IOException {

        String id=((MenuItem)e.getSource()).getId();

        if(id.equalsIgnoreCase("new_file")){
            textArea.setText("");

        } else if (id.equalsIgnoreCase("new_window")) {
            new NewWindow();

        } else if (id.equalsIgnoreCase("open")) {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Text Files");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + File.separator + "Desktop"));
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                File file = new File(String.valueOf(selectedFile));
                Path path = Path.of(String.valueOf(file));
                textArea.setText(Files.readString(path));
            }

        }else if (id.equalsIgnoreCase("save")) {

                String data = textArea.getText();
                FileChooser fileChooser1=new FileChooser();
                fileChooser1.setInitialDirectory(new File(System.getProperty("user.home") + File.separator + "Desktop"));
                FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
                fileChooser1.setTitle("Save");
                fileChooser1.getExtensionFilters().add(extensionFilter);
                File file = fileChooser1.showSaveDialog(null);
                Path fileName = Path.of(String.valueOf(file));
                Files.writeString(fileName, data);

            }  else if (id.equalsIgnoreCase("exit")) {
                System.exit(0);

            } else if (id.equalsIgnoreCase("cut")) {
                textArea.cut();

            } else if (id.equalsIgnoreCase("paste")) {
                textArea.paste();

            } else if (id.equalsIgnoreCase("copy")) {
                textArea.copy();

            } else if (id.equalsIgnoreCase("select")) {
                textArea.selectAll();

            } else if (id.equalsIgnoreCase("delete")) {
                textArea.setText("");

            }else if(id.equalsIgnoreCase("about")){
                new About().start(new Stage());
            }


        }

}
