
import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalAlgorithm {
    int vertices;
    List<Edge> edges;

    public KruskalAlgorithm(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    int find(Subset[] subsets, int node) {
        if (subsets[node].parent != node) {
            subsets[node].parent = find(subsets, subsets[node].parent);
        }
        return subsets[node].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    public void kruskalMST() {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);

        Subset[] subsets = new Subset[vertices];
        for (int i = 0; i < vertices; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int edgeCount = 0;
        int i = 0;

        while (edgeCount < vertices - 1 && i < edges.size()) {
            Edge nextEdge = edges.get(i++);
            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);

            if (x != y) {
                result.add(nextEdge);
                union(subsets, x, y);
                edgeCount++;
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : result) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        int vertices = 9;
        KruskalAlgorithm graph = new KruskalAlgorithm(vertices);

        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 3, 4);
        graph.addEdge(0, 4, 2);
        graph.addEdge(0, 5, 5);
        graph.addEdge(0, 6, 1);
        graph.addEdge(0, 7, 7);
        graph.addEdge(1, 5, 3);
        graph.addEdge(1, 7, 6);
        graph.addEdge(1, 8, 4);
        graph.addEdge(2, 6, 7);
        graph.addEdge(2, 7, 3);
        graph.addEdge(3, 6, 2);
        graph.addEdge(3, 8, 1);
        graph.addEdge(4, 6, 6);
        graph.addEdge(4, 7, 3);
        graph.addEdge(5, 8, 2);

        graph.kruskalMST();
    }
}