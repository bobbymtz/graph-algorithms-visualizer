package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Controller {
    @FXML
    private Label promptText;
    @FXML
    private Button mainButton;
    @FXML
    private AnchorPane graph;
    // the graph will hold all of the nodes, edges, buttons and text prompts

    // when the main button is first clicked a new graph will be created
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
        
    }
    
}
