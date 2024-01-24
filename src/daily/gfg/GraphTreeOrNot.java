package daily.gfg;

import java.util.ArrayList;

public class GraphTreeOrNot {

    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        if (m != n - 1) return false;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            graph.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        boolean[] visited = new boolean[n];
        dfsTraversal(graph, 0, visited);

        for (int u = 0; u < n; u++)
            if (!visited[u]) return false;
        return true;
    }

    public static void dfsTraversal(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int i : graph.get(v)) if (!visited[i]) dfsTraversal(graph, i, visited);
    }
}
