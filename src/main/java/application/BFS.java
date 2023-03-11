package application;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    private boolean[] marked;
    AnchorPane p;
    Arrow[][] l;
    Queue<Integer> q = new LinkedList<Integer>();

    public BFS(DiGraph g, int v, AnchorPane graphView, Arrow[][] lines)
    {
        p = graphView;
        l = lines;
        marked = new boolean[g.getVertexCount()];
        bfs(g, v);
    }

    public void bfs(DiGraph g, int s)
    {
        q.add(s);
        marked[s] = true;

        System.out.println("visiting " + s);
        while (!q.isEmpty())
        {
            int v = q.remove();
            for (int w : g.getAdj(v))
            {
                if (!marked[w])
                {
                    marked[w] = true;
                    q.add(w);

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
                }
            }
        }


    }

    public Node getVertex(AnchorPane p, int v)
    {
        for (Node n : p.getChildren())
        {
            if (n instanceof VertexButton)
            {
                if (((VertexButton) n).getVertexID() == v)
                {
                    return n;
                }
            }
        }
        return null;
    }
}
