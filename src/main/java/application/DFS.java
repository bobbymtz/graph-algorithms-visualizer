package application;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class DFS
{
    private boolean[] marked;
    AnchorPane p;
    Arrow[][] l;

    public DFS(DiGraph g, int v, AnchorPane graphView, Arrow[][] lines)
    {
        p = graphView;
        l = lines;
        marked = new boolean[g.getVertexCount()];
        dfs(g, v);
    }

    public void dfs(DiGraph g, int v)
    {
        marked[v] = true;

        System.out.println("visiting " + v);
        for (int w : g.getAdj(v))
        {
            if (!marked[w])
            {
                marked[w] = true;

                getVertex(p, w).setStyle("-fx-background-color: green");
                l[v][w].setFill(Color.ALICEBLUE);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                dfs(g, w);
            }
        }
        
        
    }
    public Node getVertex(AnchorPane p, int v)
    {
        for(Node n: p.getChildren())
        {
            if (n instanceof VertexButton)
            {
                if (((VertexButton)n).getVertexID() == v)
                {
                    return n;
                }
            }  
        }
        return null;
    }
}
