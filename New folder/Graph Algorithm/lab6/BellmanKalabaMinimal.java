
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BellmanKalabaMinimal {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void bellmanKalaba(int vertices, int edgesCount, Edge[] edges, int startNode) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (distances[edge.source] != Integer.MAX_VALUE &&
                        distances[edge.source] + edge.weight < distances[edge.destination]) {
                    distances[edge.destination] = distances[edge.source] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (distances[edge.source] != Integer.MAX_VALUE &&
                    distances[edge.source] + edge.weight < distances[edge.destination]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t " + (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }

    public static void main(String[] args) {
        int vertices = 9;
        int edgesCount = 14;

        Edge[] edges = new Edge[edgesCount];

        edges[0] = new Edge(0, 1, 8);
        edges[1] = new Edge(0, 2, 6);
        edges[2] = new Edge(0, 3, 10);
        edges[3] = new Edge(1, 2, 3);
        edges[4] = new Edge(1, 6, 12);
        edges[5] = new Edge(2, 4, 9);
        edges[6] = new Edge(2, 6, 7);
        edges[7] = new Edge(2, 7, 11);
        edges[8] = new Edge(3, 4, 4);
        edges[9] = new Edge(3, 5, 6);
        edges[10] = new Edge(4, 6, 5);
        edges[11] = new Edge(4, 7, 9);
        edges[12] = new Edge(5, 7, 7);
        edges[13] = new Edge(5, 8, 12);

        int startNode = 0;

        bellmanKalaba(vertices, edgesCount, edges, startNode);
    }
}
