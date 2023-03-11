package application;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class VertexButton extends Button
{
    private int vertexID;
    public VertexButton()
    {

    }
    public void setVertexID(int i)
    {
        vertexID = i;
        this.setText(vertexID + "");
    }
    public int getVertexID()
    {
        return vertexID;
    }
    @Override
    public String toString()
    {
        return this.getLayoutX() + " " + this.getLayoutY();
    }
    
}
