public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] frequencies = new int[args.length - 1];
        
        // Parse frequencies from command line arguments
        for (int i = 0; i < frequencies.length; i++) {
            frequencies[i] = Integer.parseInt(args[i + 1]);
        }
        
        int n = frequencies.length;
        int[] cumulativeSums = new int[n];
        
        // Calculate cumulative sums
        cumulativeSums[0] = frequencies[0];
        for (int i = 1; i < n; i++) {
            cumulativeSums[i] = cumulativeSums[i - 1] + frequencies[i];
        }
        
        // Generate random indices
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * cumulativeSums[n - 1]);
            int index = 0;
            while (index < n && r >= cumulativeSums[index]) {
                index++;
            }
            System.out.print((index + 1) + " ");
        }
    }
}
