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
    private AnchorPane graphView;
    private Arrow[][] lines = new Arrow[10][10];
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
            promptText.setText("Click on \"Topological Sort\" to get a topological sort.");
            mainButton.setText("Topological Sort");
            stage = stages[3];

            mainButton.setText("Topological Sort");

        }
        else if (stage.equals(stages[3]))
        {

            // BFS d = new BFS(graph, ((VertexButton) e.getSource()).getVertexID(), graphView,
            // lines);
            IntuitiveTopological i = new IntuitiveTopological(graph);
            String out = "";
            if (!i.isDAG())
            {
                promptText.setText("No Topological sort exists: A cycle was detected.");
            }
            else
            {
                for (Integer in : i.order())
                {
                    out += in + "->";
                }
                out = out.substring(0,out.length()-2);
                promptText.setText("A Topological sort is: " + out);
            }
            stage = stages[4];
            mainButton.setText("Click here to return to the home screen.");
                
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
            v.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    if (stage.equals(stages[2]))
                    {
                        if (v1 == null)
                        {
                            v1 = (VertexButton) e.getSource();
                        }
                        else if (v2 == null)
                        {

                            v2 = (VertexButton) e.getSource();
                            System.out.println("v1 is " + v1);
                            System.out.println("v2 is " + v2);
                            Arrow l = new Arrow(v1.getLayoutX(), v1.getLayoutY(), v2.getLayoutX(),
                                    v2.getLayoutY());
                            l.setStrokeWidth(3);
                            graphView.getChildren().add(l);
                            lines[v1.getVertexID()][v2.getVertexID()] = l;
                            System.out.println("added a line");
                            graph.addEdge(v1.getVertexID(), v2.getVertexID());
                            v1 = null;
                            v2 = null;
                        }
                    }



                }
            });
            graph.addVertex(v.getVertexID());

            graphView.getChildren().add(v);
        }

    }
}
