package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application
{
    public static Color purple = Color.MEDIUMPURPLE;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, purple);
        stage.setScene(scene);
        stage.setTitle("Graph Algorithms Visualizer");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}
