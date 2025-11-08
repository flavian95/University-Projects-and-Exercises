import java.util.*;

public class EulerHouse {
    static class Graph {
        private final int vertices;
        private final List<List<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        public int degree(int v) {
            return adjacencyList.get(v).size();
        }

        public boolean isEulerianCircuit() {
            for (int i = 0; i < vertices; i++) {
                if (degree(i) % 2 != 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEulerianPath() {
            int oddDegreeCount = 0;
            for (int i = 0; i < vertices; i++) {
                if (degree(i) % 2 != 0) {
                    oddDegreeCount++;
                }
            }
            return oddDegreeCount == 2 || oddDegreeCount == 0;
        }

        public boolean isBipartite() {
            int[] colors = new int[vertices];
            Arrays.fill(colors, -1);

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < vertices; i++) {
                if (colors[i] == -1) {
                    queue.add(i);
                    colors[i] = 0;

                    while (!queue.isEmpty()) {
                        int current = queue.poll();
                        for (int neighbor : adjacencyList.get(current)) {
                            if (colors[neighbor] == -1) {
                                colors[neighbor] = 1 - colors[current];
                                queue.add(neighbor);
                            } else if (colors[neighbor] == colors[current]) {
                                return false; // Not bipartite
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> roomMap = new HashMap<>();
        String[] rooms = {
                "Front Door", "Piano Rm", "Living Rm", "Study", "Master Bd",
                "Conservatory", "Family Rm", "Kitchen", "Dining Rm", "Garage", "Yard", "Hall"
        };
        for (int i = 0; i < rooms.length; i++) {
            roomMap.put(rooms[i], i);
        }

        Graph houseGraph = new Graph(rooms.length);
        houseGraph.addEdge(roomMap.get("Front Door"), roomMap.get("Hall"));
        houseGraph.addEdge(roomMap.get("Hall"), roomMap.get("Piano Rm"));
        houseGraph.addEdge(roomMap.get("Hall"), roomMap.get("Living Rm"));
        houseGraph.addEdge(roomMap.get("Living Rm"), roomMap.get("Study"));
        houseGraph.addEdge(roomMap.get("Living Rm"), roomMap.get("Master Bd"));
        houseGraph.addEdge(roomMap.get("Master Bd"), roomMap.get("Conservatory"));
        houseGraph.addEdge(roomMap.get("Conservatory"), roomMap.get("Family Rm"));
        houseGraph.addEdge(roomMap.get("Family Rm"), roomMap.get("Kitchen"));
        houseGraph.addEdge(roomMap.get("Kitchen"), roomMap.get("Dining Rm"));
        houseGraph.addEdge(roomMap.get("Dining Rm"), roomMap.get("Garage"));
        houseGraph.addEdge(roomMap.get("Garage"), roomMap.get("Yard"));
        houseGraph.addEdge(roomMap.get("Yard"), roomMap.get("Kitchen"));
        houseGraph.addEdge(roomMap.get("Hall"), roomMap.get("Kitchen"));

        boolean isEulerianCircuit = houseGraph.isEulerianCircuit();
        boolean isEulerianPath = houseGraph.isEulerianPath();

        System.out.println("Problem 1: Eulerian Path/Circuit");
        if (isEulerianCircuit) {
            System.out.println(
                    "Baby Euler can walk through every door exactly once and return to the starting point (Eulerian Circuit).");
        } else if (isEulerianPath) {
            System.out.println(
                    "Baby Euler can walk through every door exactly once but must start and end at different points (Eulerian Path).");
        } else {
            System.out.println("Baby Euler cannot walk through every door exactly once.");
        }

        boolean isBipartite = houseGraph.isBipartite();

        System.out.println("\nProblem 2: 2-Coloring (Bipartite)");
        if (isBipartite) {
            System.out.println(
                    "Yes, it is possible to paint the rooms blue and yellow such that adjacent rooms have different colors.");
        } else {
            System.out.println(
                    "No, it is not possible to paint the rooms with two colors without adjacent rooms sharing the same color.");
        }
    }
}