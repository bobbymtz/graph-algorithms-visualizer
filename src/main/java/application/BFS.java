package application;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    private boolean[] marked;
    AnchorPane pane;
    Arrow[][] edges;
    Queue<Integer> q = new LinkedList<Integer>();

    public BFS(DiGraph g, int v, AnchorPane graphView, Arrow[][] lines)
    {
        pane = graphView;
        edges = lines;
        marked = new boolean[g.getVertexCount()];
        bfs(g, v);
    }

    public void bfs(DiGraph g, int s)
    {
        q.add(s);
        marked[s] = true;

        while (!q.isEmpty())
        {
            int v = q.remove();
            for (int w : g.getAdj(v))
            {
                if (!marked[w])
                {
                    marked[w] = true;
                    q.add(w);
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
