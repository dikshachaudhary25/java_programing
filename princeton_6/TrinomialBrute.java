public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Base case: T(0, 0) = 1, T(n, k) = 0 for all other cases where n != 0 and k != 0
        if (n == 0 && k == 0) {
            return 1;
        } else if (k < -n || k > n) {
            // Base case: T(n, k) = 0 if |k| > n
            return 0;
        } else {
            // Recursively compute trinomial coefficients
            return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java TrinomialBrute <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        long result = trinomial(n, k);
        System.out.println(result);
    }
}
