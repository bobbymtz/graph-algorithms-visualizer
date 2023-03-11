package application;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

public class DiGraph
{
    private Map<Integer, LinkedList<Integer>> map;
    private int V;
    private int E;

    public DiGraph()
    {
        this.V = 0;
        this.E = 0;
        this.map = new HashMap<>();

    }

    public void addEdge(int v, int w)
    {
        if (!containsVertex(v))
        {
            addVertex(v);
        }
        if (!containsVertex(w))
        {
            addVertex(w);
        }
        map.get(v).add(w);
        E++;
    }

    public void addVertex(int v)
    {
        if (!containsVertex(v))
        {
            map.put(v, new LinkedList<Integer>());
            V++;
        }
    }

    public Iterable<Integer> getAdj(int v)
    {
        return map.get(v);
    }

    public int getEdgeCount()
    {
        return E;
    }

    public int getIndegree(int v) throws NoSuchElementException
    {
        if (!containsVertex(v))
        {
            throw new NoSuchElementException();
        }
        int count = 0;
        for (Integer w : map.keySet())
        {
            if (map.get(w).contains(v))
            {
                count++;
            }
        }
        return count;

    }

    public int getVertexCount()
    {
        return V;
    }

    public void removeEdge(int v, int w)
    {
        if (containsVertex(v) && containsVertex(w))
        {
            map.get(v).remove((Integer) w);
            E--;
        }

    }

    public void removeVertex(int v)
    {
        E -= map.get(v).size();
        map.remove(v);
        V--;
    }

    public Iterable<Integer> vertices()
    {
        return map.keySet();
    }

    public boolean isEmpty()
    {
        return V == 0;
    }

    public boolean containsVertex(int v)
    {
        return map.containsKey(v);
    }

}
