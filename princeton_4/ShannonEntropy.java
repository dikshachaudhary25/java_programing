public class ShannonEntropy {
    public static void main(String[] args) {
        // Read the value of m from command-line arguments
        int m = Integer.parseInt(args[0]);

        // Initialize an array to store the frequencies of integers
        int[] frequencies = new int[m + 1];
        int totalCount = 0;

        // Read integers from standard input and update frequencies
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            frequencies[value]++;
            totalCount++;
        }

        // Calculate Shannon entropy
        double entropy = 0.0;
        for (int frequency : frequencies) {
            if (frequency > 0) {
                double probability = (double) frequency / totalCount;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }

        // Print Shannon entropy with 4 decimal points
        System.out.printf("%.4f\n", entropy);
    }
}
