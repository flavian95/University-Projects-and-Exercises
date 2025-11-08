
import java.util.*;

public class KonigsbergBridgeProblem {
    static class Graph {
        int vertices;
        List<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        public boolean hasEulerianCircuit() {
            for (int i = 0; i < vertices; i++) {
                if (adjacencyList[i].size() % 2 != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 3);

        if (graph.hasEulerianCircuit()) {
            System.out.println("The graph has an Eulerian circuit.");
        } else {
            System.out.println("The graph does NOT have an Eulerian circuit.");
        }
    }
}
