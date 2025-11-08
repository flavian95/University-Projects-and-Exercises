
import java.util.*;

public class ConvexHull {

    // A point class to represent a 2D point
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to find orientation of ordered triplet (p, q, r)
    // Returns 0 if p, q, and r are collinear
    // Returns 1 if Clockwise
    // Returns 2 if Counterclockwise
    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0)
            return 0; // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }

    // Function to sort points based on x-coordinate
    static void sortPointsByX(List<Point> points) {
        points.sort(Comparator.comparingInt(a -> a.x));
    }

    // Function to compute convex hull
    static List<Point> computeConvexHull(List<Point> points) {
        int n = points.size();
        if (n < 3)
            return null; // Convex hull is not possible

        // Sort points by x-coordinate
        sortPointsByX(points);

        List<Point> convexHull = new ArrayList<>();

        // Step 1: Upper hull
        for (int i = 0; i < n; i++) {
            while (convexHull.size() >= 2 &&
                    orientation(convexHull.get(convexHull.size() - 2),
                            convexHull.get(convexHull.size() - 1),
                            points.get(i)) != 2) {
                convexHull.remove(convexHull.size() - 1);
            }
            convexHull.add(points.get(i));
        }

        // Step 2: Lower hull
        int sizeBeforeLowerHull = convexHull.size();
        for (int i = n - 2; i >= 0; i--) {
            while (convexHull.size() > sizeBeforeLowerHull &&
                    orientation(convexHull.get(convexHull.size() - 2),
                            convexHull.get(convexHull.size() - 1),
                            points.get(i)) != 2) {
                convexHull.remove(convexHull.size() - 1);
            }
            convexHull.add(points.get(i));
        }

        // Remove the last point because it is repeated
        convexHull.remove(convexHull.size() - 1);

        return convexHull;
    }

    public static void main(String[] args) {
        // Input points
        List<Point> points = Arrays.asList(
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 0),
                new Point(0, 0),
                new Point(3, 3));

        // Compute the convex hull
        List<Point> convexHull = computeConvexHull(points);

        // Output the result
        if (convexHull != null) {
            System.out.println("Points in the Convex Hull:");
            for (Point p : convexHull) {
                System.out.println("(" + p.x + ", " + p.y + ")");
            }
        } else {
            System.out.println("Convex hull is not possible for the given points.");
        }
    }
}
