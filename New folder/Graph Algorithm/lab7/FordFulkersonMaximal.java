
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonMaximal {
    static final int V = 8;

    private boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                    if (v == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int fordFulkerson(int[][] graph, int source, int sink) {
        int[][] residualGraph = new int[V][V];
        int maxFlow = 0;

        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V];

        while (bfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        // Example graph
        int[][] graph = {
                { 0, 10, 10, 0, 0, 0, 0, 0 },
                { 0, 0, 2, 4, 8, 0, 0, 0 },
                { 0, 0, 0, 0, 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 10, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 10, 10 },
                { 0, 0, 0, 0, 0, 0, 2, 8 },
                { 0, 0, 0, 0, 0, 0, 0, 10 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        FordFulkersonMaximal ff = new FordFulkersonMaximal();
        int source = 0, sink = 7;

        System.out.println("The maximum possible flow is " +
                ff.fordFulkerson(graph, source, sink));
    }
}
