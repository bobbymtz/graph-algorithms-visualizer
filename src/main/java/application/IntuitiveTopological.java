package application;

import java.util.HashMap;
import java.util.LinkedList;

public class IntuitiveTopological
{
    private HashMap<Integer, Boolean> marked;
    private HashMap<Integer, Boolean> onStack;
    private boolean hasCycle;
    private LinkedList<Integer> order;
    DiGraph graph;

    public IntuitiveTopological(DiGraph graph)
    {
        marked = new HashMap<>();
        onStack = new HashMap<>();
        order = new LinkedList<>();
        this.graph = graph;
        hasCycle = false;
        for (Integer v : graph.vertices())
        {
            marked.put(v, false);
            onStack.put(v, false);
        }
        for (Integer v : graph.vertices())
        {
            if (!marked.get(v))
            {
                dfs(graph, v);
            }
        }

    }

    public Iterable<Integer> order()
    {
        if (!isDAG()) return null;
        while (!graph.isEmpty())
        {
            Integer toDelete = null;
            for (Integer v : graph.vertices())
            {
                if (graph.getIndegree(v) == 0)
                {
                    toDelete = v;
                    break;
                }
            }
            order.add(toDelete);
            graph.removeVertex(toDelete);
        }
        return order;

    }

    public boolean isDAG()
    {
        return !hasCycle;
    }

    private void dfs(DiGraph graph, int v)
    {
        onStack.put(v, true);
        marked.put(v, true);
        for (int w : graph.getAdj(v))
        {
            if (hasCycle)
            {
                return;
            }
            else if (!marked.get(w))
            {
                dfs(graph, w);
            }
            else if (onStack.get(w))
            {
                hasCycle = true;
            }

        }
        onStack.put(v, false);
    }

}