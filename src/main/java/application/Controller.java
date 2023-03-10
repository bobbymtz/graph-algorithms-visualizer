package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML
    private Label promptText;
    @FXML
    private Button mainButton;
    @FXML
    private AnchorPane graph;

    public void clickStart(ActionEvent e)
    {
        promptText.setText("Click anywhere on the graph to add a vertex. Click \"Done\" when finished.");
        mainButton.setText("Done");
    }
    public void addVertex(MouseEvent m)
    {
        VertexButton v = new VertexButton();
        v.setLayoutX(m.getX());
        v.setLayoutY(m.getY());
        
        graph.getChildren().add(v);
        
        System.out.println("Mouse clicked");
    }
    
}
