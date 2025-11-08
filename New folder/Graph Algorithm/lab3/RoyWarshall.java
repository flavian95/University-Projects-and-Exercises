public class RoyWarshall {
    public static void royWarshall(int[][] matrix) {
        int n = matrix.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = (matrix[i][j] != 0) || (matrix[i][k] != 0 && matrix[k][j] != 0) ? 1 : 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] roadMatrix1 = {
                { 1, 0, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 1 }
        };

        int[][] roadMatrix2 = {
                { 0, 1, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0 }
        };

        System.out.println("Original Matrix 1:");
        printMatrix(roadMatrix1);
        royWarshall(roadMatrix1);
        System.out.println("\nTransitive Closure for Matrix 1:");
        printMatrix(roadMatrix1);

        System.out.println("\nOriginal Matrix 2:");
        printMatrix(roadMatrix2);
        royWarshall(roadMatrix2);
        System.out.println("\nTransitive Closure for Matrix 2:");
        printMatrix(roadMatrix2);
    }
}
