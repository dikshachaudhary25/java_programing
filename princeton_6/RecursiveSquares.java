public class RecursiveSquares {
    // Draw a square centered at (x, y) with the given side length
    public static void drawSquare(double x, double y, double length) {
        StdDraw.filledSquare(x, y, length / 2);
    }

    // Recursively draw the pattern
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        
        // Draw the current square
        drawSquare(x, y, length);
        
        // Calculate the coordinates for the smaller squares
        double halfLength = length / 2;
        double xLeft = x - halfLength / 2;
        double xRight = x + halfLength / 2;
        double yBottom = y - halfLength / 2;
        double yTop = y + halfLength / 2;
        
        // Recursively draw the smaller squares
        draw(n - 1, xLeft, yBottom, halfLength);
        draw(n - 1, xLeft, yTop, halfLength);
        draw(n - 1, xRight, yBottom, halfLength);
        draw(n - 1, xRight, yTop, halfLength);
    }

    // Main method
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
