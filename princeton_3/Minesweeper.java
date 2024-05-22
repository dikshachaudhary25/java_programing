public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        
        char[][] grid = new char[m][n];
        
        // Place mines
        for (int i = 0; i < k; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * m);
                y = (int) (Math.random() * n);
            } while (grid[x][y] == '*');
            grid[x][y] = '*';
        }
        
        // Count neighboring mines and print grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '*') {
                    int count = 0;
                    for (int p = Math.max(0, i - 1); p <= Math.min(m - 1, i + 1); p++) {
                        for (int q = Math.max(0, j - 1); q <= Math.min(n - 1, j + 1); q++) {
                            if (grid[p][q] == '*') {
                                count++;
                            }
                        }
                    }
                    grid[i][j] = (char) ('0' + count);
                }
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
