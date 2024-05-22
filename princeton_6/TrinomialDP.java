public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // If k is out of bounds, the trinomial coefficient is zero
        if (Math.abs(k) > n) {
            return 0;
        }

        long[][] dp = new long[n + 1][2 * n + 1];

        dp[0][n] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * n; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
                if (j < 2 * n) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
            }
        }

        return dp[n][k + n];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java TrinomialDP <n> <k>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        long result = trinomial(n, k);
        System.out.println(result);
    }
}
