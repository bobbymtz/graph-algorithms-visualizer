package application;

import javafx.scene.control.Button;

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
    
}
