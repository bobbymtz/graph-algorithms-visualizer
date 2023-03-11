package application;

import javafx.scene.control.Button;

public class VertexButton extends Button
{
    private int vertexID;

    public VertexButton()
    {

    }

    public void setVertexID(int v)
    {
        vertexID = v;
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
