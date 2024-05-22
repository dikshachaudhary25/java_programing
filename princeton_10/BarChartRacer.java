import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: java BarChartRacer <filename> <k>");
        }

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        // Read data from file using In class
        In in = new In(filename);
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();

        BarChart chart = new BarChart(title, xAxisLabel, dataSource);

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        while (in.hasNextLine()) {
            String line = in.readLine().trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                line = in.readLine();
                String[] parts = line.split(",");
                // String year = parts[0]; // Removed unused variable
                String name = parts[1];
                String category = parts[2];
                int value = Integer.parseInt(parts[3]);

                bars[i] = new Bar(name, value, category);
            }

            Arrays.sort(bars, Collections.reverseOrder());

            chart.reset();
            StdDraw.clear();
            if (bars.length > 0) {
                chart.setCaption(bars[0].getName());
            }
            for (int i = 0; i < Math.min(k, n); i++) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
