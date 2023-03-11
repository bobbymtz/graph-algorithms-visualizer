package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller
{
    @FXML
    private Label promptText;
    @FXML
    private Button mainButton;
    @FXML
    private AnchorPane graphView;;
    // the graph will hold all of the nodes, edges, buttons and text prompts
    private static int count = 0;
    private DiGraph graph = new DiGraph();
    private String[] stages =
    {"create", "nodes", "edges", "search", "done"};
    private String stage = "create";
    VertexButton v1 = null;
    VertexButton v2 = null;

    // when the main button is first clicked a new graph will be created
    public void clickStart(ActionEvent e)
    {
        if (stage.equals(stages[0]))
        {
            promptText.setText(
                    "Click anywhere on the graph to add a vertex. Click \"Done adding vertices.\" when finished.");
            mainButton.setText("Done adding vertices.");
            stage = stages[1];
        }
        else if (stage.equals(stages[1]))
        {
            promptText.setText(
                    "Click on a vertex to start an edge and then click on another vertex to end an edge. Click \"Done adding edges\" when finished");
            mainButton.setText("Done adding edges.");
            stage = stages[2];

        }
        else if (stage.equals(stages[2]))
        {
            promptText.setText("Click on \"DFS\" or \"BFS\" to begin a graph traversal.");
            mainButton.setText("DFS");
            stage = stages[3];
            graphView.getChildren().remove(mainButton);
            mainButton = new Button();
            mainButton.setText("DFS");
            mainButton.setLayoutX(400);
            mainButton.setLayoutY(700);

            Button BFS = new Button();
            BFS.setText("BFS");
            BFS.setLayoutX(600);
            BFS.setLayoutY(700);
            graphView.getChildren().add(mainButton);
            graphView.getChildren().add(BFS);

        }
    }

    public void addVertex(MouseEvent m)
    {
        if (stage.equals(stages[1]))
        {
            VertexButton v = new VertexButton();
            v.setLayoutX(m.getX());
            v.setLayoutY(m.getY());
            v.translateXProperty().bind(v.widthProperty().divide(-2));
            v.translateYProperty().bind(v.heightProperty().divide(-2));
            v.setVertexID(count++);
            v.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    System.out.println(((VertexButton) e.getSource()).getVertexID()+ " pressed");
                    if (v1 == null)
                    {
                        v1 = (VertexButton)e.getSource();
                    }
                    else if (v2 == null)
                    {

                        v2 = (VertexButton)e.getSource();
                        System.out.println("v1 is " + v1);
                        System.out.println("v2 is " + v2);
                        Line l = new Line();
                        l.setStartX(v1.getLayoutX());
                        l.setStartY(v1.getLayoutY());
                        l.setEndX(v2.getLayoutX());
                        l.setEndY(v2.getLayoutY());
                        graphView.getChildren().add(l);
                        System.out.println("added a line");
                        v1 = null;
                        v2 = null;
                    }

                }
            });
            graph.addVertex(v.getVertexID());

            graphView.getChildren().add(v);
        }

    }
}
