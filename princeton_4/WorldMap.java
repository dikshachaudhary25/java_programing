import java.util.Scanner;

public class WorldMap {
    public static void main(String[] args) {
        // Read width and height from standard input
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        
        // Set canvas size and scales
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        // Read and draw regions
        while (scanner.hasNext()) {
            String regionName = scanner.next();
            int numVertices = scanner.nextInt();
            double[] xCoords = new double[numVertices];
            double[] yCoords = new double[numVertices];
            for (int i = 0; i < numVertices; i++) {
                xCoords[i] = scanner.nextDouble();
                yCoords[i] = scanner.nextDouble();
            }
            StdDraw.polygon(xCoords, yCoords);
        }
        
        // Close the scanner
        scanner.close();
    }
}
