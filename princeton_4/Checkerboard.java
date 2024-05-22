import java.awt.Color;

public class WorldMap {
    public static void main(String[] args) {
        // Enable double buffering for improved performance
        StdDraw.enableDoubleBuffering();

        // Read the width and height from standard input
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        // Set canvas size and scale
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // Read and draw each region
        while (!StdIn.isEmpty()) {
            // Read the region name
            String regionName = StdIn.readString();

            // Read the number of vertices for the polygon
            int numVertices = StdIn.readInt();

            // Initialize arrays to store x and y coordinates of vertices
            double[] xCoords = new double[numVertices];
            double[] yCoords = new double[numVertices];

            // Read and store the x and y coordinates of vertices
            for (int i = 0; i < numVertices; i++) {
                xCoords[i] = StdIn.readDouble();
                yCoords[i] = StdIn.readDouble();
            }

            // Draw the polygon for the current region
            StdDraw.polygon(xCoords, yCoords);
        }

        // Show the drawing
        StdDraw.show();

        // Disable double buffering to show the final result
        StdDraw.disableDoubleBuffering();
    }
}
