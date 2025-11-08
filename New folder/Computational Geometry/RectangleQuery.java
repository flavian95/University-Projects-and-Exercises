
import java.util.ArrayList;
import java.util.List;

public class RectangleQuery {

    // Define a class for representing points
    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Method to count how many points lie inside the rectangle
    public static int countPointsInRectangle(List<Point> points, double alpha1, double alpha2, double beta1,
            double beta2) {
        int count = 0;

        // Iterate over all points
        for (Point p : points) {
            if (p.x >= alpha1 && p.x <= alpha2 && p.y >= beta1 && p.y <= beta2) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // List of points
        List<Point> points = new ArrayList<>();
        points.add(new Point(1.0, 2.0));
        points.add(new Point(3.0, 4.0));
        points.add(new Point(5.0, 6.0));
        points.add(new Point(7.0, 8.0));
        points.add(new Point(2.5, 3.5));

        // Define the rectangle [alpha1, alpha2] x [beta1, beta2]
        double alpha1 = 2.0, alpha2 = 6.0;
        double beta1 = 2.0, beta2 = 6.0;

        // Count how many points are inside the rectangle
        int count = countPointsInRectangle(points, alpha1, alpha2, beta1, beta2);

        // Output the result
        System.out.println("Number of points inside the rectangle: " + count);
    }
}
