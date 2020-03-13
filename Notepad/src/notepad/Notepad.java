/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author sara
 */
public class Notepad extends Application
{

    public void init()
    {
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MenuBar bar = new MenuBar();
        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Help = new Menu("Help");
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Exit = new MenuItem("Exit");
        MenuItem Undo = new MenuItem("Undo");
        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");
        MenuItem Delete = new MenuItem("Delete");
        MenuItem SelectAll = new MenuItem("Select All");
        MenuItem About = new MenuItem("About Notepad");
        TextArea textArea = new TextArea();

        VBox vbox = new VBox(textArea);
        //Creating the mouse event handler 
        New.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Hello New");
                textArea.clear();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        Open.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Open");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                FileChooser fileChooser = new FileChooser();
                File selectedFile = fileChooser.showOpenDialog(null);

                if (selectedFile != null) {

                    textArea.appendText("File selected: " + selectedFile.getAbsolutePath());
                } else {
                    textArea.appendText("File selection cancelled.");
                }

            }
        });
        Save.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Save");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter
                        = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(primaryStage);
                FileWriter fileWriter = null;
                if (file != null) {

                    try {
                        fileWriter = new FileWriter(file);
                    } catch (IOException ex) {
                        Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        fileWriter.write(textArea.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        Exit.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println(" Exit");
                Platform.exit();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
            }
        });
        Undo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Undo");
                textArea.undo();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
          Cut.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Cut");
                textArea.cut();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Copy.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Undo");
                textArea.copy();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Paste.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("paste");
              // System.out.println( );

                textArea.paste();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Delete.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Delete");
              // System.out.println( );

                textArea.deletePreviousChar();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        SelectAll.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("SelectAll");
              // System.out.println( );

                textArea.selectAll();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
                About.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
 Alert a = new Alert(AlertType.NONE); 
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Help");
              // System.out.println( );

                  
                    a.setAlertType(AlertType.INFORMATION); 
                    a.setContentText("Help Your Self!"); 
  
                // show the dialog 
                a.show(); 
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        SeparatorMenuItem separatorMenuItem_File = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem2 = new SeparatorMenuItem();
        File.getItems().addAll(New, Open, Save, separatorMenuItem_File, Exit);
        Edit.getItems().addAll(Undo, separatorMenuItem, Cut, Copy, Paste, Delete, separatorMenuItem2, SelectAll);
        Help.getItems().addAll(About);
        bar.getMenus().addAll(File, Edit, Help);
        Exit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        New.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        New.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        Exit.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        BorderPane pane = new BorderPane();
        pane.setTop(bar);
        pane.setCenter(vbox);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setTitle("Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
