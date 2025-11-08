import java.util.*;

public class StronglyConnectedComponents {

    public static void royWarshall(int[][] graph, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = graph[i][j] | (graph[i][k] & graph[k][j]);
                }
            }
        }
    }

    public static void findSCC(int[][] reachabilityMatrix, int n) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> stronglyConnectedComponents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> scc = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (reachabilityMatrix[i][j] == 1 && reachabilityMatrix[j][i] == 1) {
                        scc.add(j);
                        visited[j] = true;
                    }
                }
                stronglyConnectedComponents.add(scc);
            }
        }

        System.out.println("Strongly Connected Components:");
        for (List<Integer> component : stronglyConnectedComponents) {
            System.out.println(component);
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = {
                { 1, 0, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 1 }
        };

        int[][] graph2 = {
                { 0, 1, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0 }
        };

        System.out.println("Processing first matrix:");
        processGraph(graph1);

        System.out.println("\nProcessing second matrix:");
        processGraph(graph2);
    }

    public static void processGraph(int[][] graph) {
        int n = graph.length;

        royWarshall(graph, n);

        findSCC(graph, n);
    }
}