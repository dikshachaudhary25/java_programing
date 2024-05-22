public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[][] weave = new boolean[n][n];
        
        // Generate Thue-Morse sequence
        boolean[] sequence = new boolean[n * n];
        for (int i = 0; i < n * n; i++) {
            sequence[i] = Integer.bitCount(i) % 2 == 1;
        }
        
        // Generate weave pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weave[i][j] = sequence[i] == sequence[j];
                System.out.print(weave[i][j] ? "+  " : "-  ");
            }
            System.out.println();
        }
    }
}
