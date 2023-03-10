package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label promptText;
    @FXML
    private Button mainButton;

    public void clickStart(ActionEvent e)
    {
        promptText.setText("Click anywhere on the graph to add a vertex. Click \"Done\" when finished.");
        mainButton.setText("Done");
    }
    
}
