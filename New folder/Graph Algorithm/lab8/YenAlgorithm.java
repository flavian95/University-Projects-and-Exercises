
import java.util.*;

public class YenAlgorithm {

    static class Graph {
        private final int V;
        private final List<List<Edge>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Edge(v, weight));
        }

        public List<Edge> getEdges(int u) {
            return adj.get(u);
        }

        public int getVertices() {
            return V;
        }
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Path implements Comparable<Path> {
        List<Integer> nodes;
        int cost;

        public Path(List<Integer> nodes, int cost) {
            this.nodes = new ArrayList<>(nodes);
            this.cost = cost;
        }

        @Override
        public int compareTo(Path other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static List<Path> yenAlgorithm(Graph graph, int source, int target, int K) {
        List<Path> shortestPaths = new ArrayList<>();
        PriorityQueue<Path> potentialPaths = new PriorityQueue<>();

        Path firstPath = dijkstra(graph, source, target);
        if (firstPath == null)
            return shortestPaths; // No path exists
        shortestPaths.add(firstPath);

        for (int k = 1; k < K; k++) {
            Path prevPath = shortestPaths.get(k - 1);

            for (int i = 0; i < prevPath.nodes.size() - 1; i++) {
                int spurNode = prevPath.nodes.get(i);
                List<Integer> rootPath = prevPath.nodes.subList(0, i + 1);

                Graph tempGraph = cloneGraph(graph);

                for (Path path : shortestPaths) {
                    if (path.nodes.size() > i && path.nodes.subList(0, i + 1).equals(rootPath)) {
                        int spurNodeIndex = path.nodes.get(i);
                        int nextNodeIndex = path.nodes.get(i + 1);
                        tempGraph.getEdges(spurNodeIndex).removeIf(edge -> edge.to == nextNodeIndex);
                    }
                }

                for (int node : rootPath.subList(0, rootPath.size() - 1)) {
                    tempGraph.adj.set(node, new ArrayList<>());
                }

                Path spurPath = dijkstra(tempGraph, spurNode, target);
                if (spurPath != null) {
                    List<Integer> totalPath = new ArrayList<>(rootPath);
                    totalPath.addAll(spurPath.nodes.subList(1, spurPath.nodes.size()));
                    int totalCost = calculateCost(graph, totalPath);
                    potentialPaths.add(new Path(totalPath, totalCost));
                }
            }

            if (potentialPaths.isEmpty())
                break; // No more paths
            shortestPaths.add(potentialPaths.poll());
        }

        return shortestPaths;
    }

    private static Path dijkstra(Graph graph, int source, int target) {
        int[] dist = new int[graph.getVertices()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(source, 0));

        int[] prev = new int[graph.getVertices()];
        Arrays.fill(prev, -1);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.to;

            for (Edge neighbor : graph.getEdges(u)) {
                int v = neighbor.to;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        if (dist[target] == Integer.MAX_VALUE)
            return null;

        // Reconstruct the path
        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = prev[at]) {
            path.add(0, at);
        }

        return new Path(path, dist[target]);
    }

    private static Graph cloneGraph(Graph graph) {
        Graph newGraph = new Graph(graph.getVertices());
        for (int u = 0; u < graph.getVertices(); u++) {
            for (Edge edge : graph.getEdges(u)) {
                newGraph.addEdge(u, edge.to, edge.weight);
            }
        }
        return newGraph;
    }

    private static int calculateCost(Graph graph, List<Integer> path) {
        int totalCost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int u = path.get(i);
            int v = path.get(i + 1);
            for (Edge edge : graph.getEdges(u)) {
                if (edge.to == v) {
                    totalCost += edge.weight;
                    break;
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 7, 9);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 5, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 7, 6);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 3);
        graph.addEdge(4, 6, 2);
        graph.addEdge(5, 6, 5);
        graph.addEdge(6, 7, 2);

        int source = 0, target = 7, K = 2;

        List<Path> paths = yenAlgorithm(graph, source, target, K);

        for (int i = 0; i < paths.size(); i++) {
            System.out.println("Path " + (i + 1) + ": " + paths.get(i).nodes + " (Cost: " + paths.get(i).cost + ")");
        }
    }
}
