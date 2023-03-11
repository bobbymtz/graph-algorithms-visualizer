package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // the fxml file is the root node for the initial scene
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setResizable(false);
        stage.setTitle("Graph Algorithms Visualizer");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}
