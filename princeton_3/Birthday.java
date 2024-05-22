public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        
        int[] count = new int[n + 1];
        
        for (int t = 0; t < trials; t++) {
            boolean[] birthdays = new boolean[n];
            int people = 0;
            while (true) {
                people++;
                int birthday = (int) (Math.random() * n);
                if (birthdays[birthday]) {
                    break;
                }
                birthdays[birthday] = true;
            }
            count[people]++;
        }
        
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += count[i];
            double fraction = (double) total / trials;
            System.out.printf("%d\t%d\t%.6f\n", i, count[i], fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
