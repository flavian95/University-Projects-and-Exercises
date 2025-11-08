import java.util.*;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class PointsInRectangle {

    public static void main(String[] args) {
        // Define the rectangle D by its boundaries
        double alpha1 = 1.0, alpha2 = 5.0;
        double beta1 = 1.0, beta2 = 5.0;

        // Create a list of points X = {P1, ..., Pn}
        List<Point> points = generateRandomPoints(40, 0, 10); // Generate 40 points in range (0, 10)

        // Find points inside the rectangle D
        List<Point> pointsInsideRectangle = getPointsInsideRectangle(points, alpha1, alpha2, beta1, beta2);

        // Print the results
        System.out.println("Total points inside the rectangle: " + pointsInsideRectangle.size());
        System.out.println("Points inside the rectangle: " + pointsInsideRectangle);
    }

    // Method to generate random points
    public static List<Point> generateRandomPoints(int count, double min, double max) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            double x = min + (max - min) * random.nextDouble();
            double y = min + (max - min) * random.nextDouble();
            points.add(new Point(x, y));
        }
        return points;
    }

    // Method to find points inside a rectangle
    public static List<Point> getPointsInsideRectangle(List<Point> points, double alpha1, double alpha2, double beta1, double beta2) {
        List<Point> insidePoints = new ArrayList<>();

        for (Point p : points) {
            if (p.x > alpha1 && p.x < alpha2 && p.y > beta1 && p.y < beta2) {
                insidePoints.add(p);
            }
        }
        return insidePoints;
    }
}