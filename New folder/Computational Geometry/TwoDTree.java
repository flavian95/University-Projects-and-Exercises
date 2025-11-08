import java.util.*;

// Class to represent a point in 2D space
class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

// Class to represent a node in the 2D Tree
class Node {
    Point point;
    int cutType; // 0 for horizontal, 1 for vertical
    double cutValue;
    Node left, right;

    public Node(Point point, int cutType, double cutValue) {
        this.point = point;
        this.cutType = cutType;
        this.cutValue = cutValue;
        this.left = null;
        this.right = null;
    }
}

public class TwoDTree {

    Node root;

    public TwoDTree(List<Point> points) {
        // Build the 2D Tree starting from the root
        this.root = buildTree(points, 0);
    }

    private Node buildTree(List<Point> points, int depth) {
        if (points.isEmpty())
            return null;

        // Alternate between x and y coordinates
        int cutType = depth % 2;
        if (cutType == 0) {
            points.sort(Comparator.comparingDouble(p -> p.x));
        } else {
            points.sort(Comparator.comparingDouble(p -> p.y));
        }

        // Find the median
        int medianIndex = points.size() / 2;
        Point medianPoint = points.get(medianIndex);
        double cutValue = (cutType == 0) ? medianPoint.x : medianPoint.y;

        // Create a new node
        Node node = new Node(medianPoint, cutType, cutValue);

        // Recursively build left and right subtrees
        node.left = buildTree(points.subList(0, medianIndex), depth + 1);
        node.right = buildTree(points.subList(medianIndex + 1, points.size()), depth + 1);

        return node;
    }

    public void query(Node node, double alpha1, double alpha2, double beta1, double beta2, List<Point> result) {
        if (node == null)
            return;

        System.out.println("Visiting node: (" + node.point.x + ", " + node.point.y + ")");

        double l, r;
        if (node.cutType == 1) { // Vertical cut
            l = alpha1;
            r = alpha2;
        } else { // Horizontal cut
            l = beta1;
            r = beta2;
        }

        Point p = node.point;
        if (p.x >= alpha1 && p.x <= alpha2 && p.y >= beta1 && p.y <= beta2) {
            result.add(p);
            System.out.println("Point added: (" + p.x + ", " + p.y + ")");
        }

        if (node.cutValue >= l) {
            System.out.println("Exploring left child of: (" + node.point.x + ", " + node.point.y + ")");
            query(node.left, alpha1, alpha2, beta1, beta2, result);
        }

        if (node.cutValue <= r) {
            System.out.println("Exploring right child of: (" + node.point.x + ", " + node.point.y + ")");
            query(node.right, alpha1, alpha2, beta1, beta2, result);
        }
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(3, 6), new Point(17, 15), new Point(13, 15),
                new Point(6, 12), new Point(9, 1), new Point(2, 7),
                new Point(10, 19));

        TwoDTree tree = new TwoDTree(points);

        List<Point> result = new ArrayList<>();
        tree.query(tree.root, 5, 15, 5, 20, result);

        System.out.println("Points in the range:");
        for (Point p : result) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}