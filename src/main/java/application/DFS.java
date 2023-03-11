package application;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class DFS
{
    private boolean[] marked;
    AnchorPane pane;
    Arrow[][] edges;

    public DFS(DiGraph g, int v, AnchorPane graphView, Arrow[][] lines)
    {
        pane = graphView;
        edges = lines;
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
                dfs(g, w);
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
