
import java.util.*;

class FordFulkersonMinimal {
    private int vertices;
    private int[][] residualGraph;

    public FordFulkersonMinimal(int vertices) {
        this.vertices = vertices;
        residualGraph = new int[vertices][vertices];
    }

    private boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < vertices; v++) {
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
        for (int u = 0; u < vertices; u++) {
            for (int v = 0; v < vertices; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[vertices];
        int maxFlow = 0;

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
        int[][] graph = {
                { 0, 16, 13, 0, 0, 0 },
                { 0, 0, 10, 12, 0, 0 },
                { 0, 4, 0, 0, 14, 0 },
                { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 4 },
                { 0, 0, 0, 0, 0, 0 }
        };

        FordFulkersonMinimal ff = new FordFulkersonMinimal(graph.length);
        int source = 0, sink = 5;
        System.out.println("The maximum possible flow is: " + ff.fordFulkerson(graph, source, sink));
    }
}