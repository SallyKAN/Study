import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args){
        graph g = new graph(7);
        g.addEdge(1,3);
        g.addEdge(1,5);
        g.addEdge(1,4);
        g.addEdge(1,2);
        g.addEdge(3,5);
        g.addEdge(5,4);

    }
}

class graph {
    private int V;
    private LinkedList<Integer> adj[];

    public graph(int v) {
        V = v;
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DfsUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DfsUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DfsUtil(v,visited);
    }
}
