
import java.util.Arrays;

public class RoyFloydMaximum {

    public static void main(String[] args) {
        int INF = Integer.MIN_VALUE;

        int[][] graph = {
                { 0, 1, 7, INF, INF, INF },
                { INF, 0, INF, 5, INF, INF },
                { INF, 2, 0, INF, 8, INF },
                { INF, INF, INF, 0, INF, 3 },
                { INF, INF, INF, 4, 0, INF },
                { INF, INF, INF, INF, INF, 0 }
        };

        int n = graph.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.max(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        printGraph(graph, INF);
    }

    private static void printGraph(int[][] graph, int INF) {
        System.out.println("Resultant Maximum Path Matrix:");
        for (int[] row : graph) {
            for (int value : row) {
                if (value == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }
}