import java.util.*;

public class SCC {
    static int V = 10;
    static List<List<Integer>> adj1;
    static List<List<Integer>> adjTranspose1;
    static List<List<Integer>> adj2;
    static List<List<Integer>> adjTranspose2;

    public static void main(String[] args) {
        adj1 = new ArrayList<>(V);
        adjTranspose1 = new ArrayList<>(V);
        adj2 = new ArrayList<>(V);
        adjTranspose2 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj1.add(new ArrayList<>());
            adjTranspose1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
            adjTranspose2.add(new ArrayList<>());
        }

        int[][] graph1 = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }
        };

        int[][] graph2 = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }
        };

        buildAdjacencyList(graph1, adj1, adjTranspose1);
        buildAdjacencyList(graph2, adj2, adjTranspose2);

        System.out.println("Strongly Connected Components for the first graph:");
        findSCC(adj1, adjTranspose1);

        System.out.println("Strongly Connected Components for the second graph:");
        findSCC(adj2, adjTranspose2);
    }

    static void buildAdjacencyList(int[][] graph, List<List<Integer>> adj, List<List<Integer>> adjTranspose) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] == 1) {
                    adj.get(i).add(j);
                    adjTranspose.get(j).add(i);
                }
            }
        }
    }

    static void findSCC(List<List<Integer>> adj, List<List<Integer>> adjTranspose) {
        boolean[] visited = new boolean[V];
        Stack<Integer> finishStack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, finishStack);
            }
        }

        Arrays.fill(visited, false);
        while (!finishStack.isEmpty()) {
            int node = finishStack.pop();
            if (!visited[node]) {
                List<Integer> scc = new ArrayList<>();
                dfsTranspose(adjTranspose, node, visited, scc);
                System.out.println(scc);
            }
        }
    }

    static void dfs(List<List<Integer>> graph, int node, boolean[] visited, Stack<Integer> finishStack) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, finishStack);
            }
        }
        finishStack.push(node);
    }

    static void dfsTranspose(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> scc) {
        visited[node] = true;
        scc.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsTranspose(graph, neighbor, visited, scc);
            }
        }
    }
}