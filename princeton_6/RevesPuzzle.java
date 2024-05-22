public class RevesPuzzle {

    // Move a disc from one pole to another
    private static void move(int disc, char from, char to) {
        System.out.println("Move disc " + disc + " from " + from + " to " + to);
    }

    // Solve the Reve's Puzzle
    private static void revesPuzzle(int n, char from, char to, char temp1, char temp2) {
        if (n == 0) return;

        // Calculate the number of discs to move to the intermediate pole
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        // Find the smallest disc on the 'from' pole
        int smallest = findSmallest(from, to, temp1, temp2, n);

        // If the smallest disc is not on the 'from' pole, move it to the 'to' pole
        if (smallest != 1)
            move(smallest, from, to);

        // Move k smallest discs to the first temporary pole
        revesPuzzle(k, from, temp1, to, temp2);

        // Move the remaining n - k discs to the target pole using the second temporary pole
        hanoi(n - k, from, to, temp2);

        // Move k smallest discs from the first temporary pole to the target pole
        revesPuzzle(k, temp1, to, from, temp2);
    }

    // Find the smallest disc on the given poles
    private static int findSmallest(char from, char to, char temp1, char temp2, int n) {
        if (from == 'A' || to == 'A' || temp1 == 'A' || temp2 == 'A') {
            return 1;
        } else if (from == 'B' || to == 'B' || temp1 == 'B' || temp2 == 'B') {
            return n;
        } else if (from == 'C' || to == 'C' || temp1 == 'C' || temp2 == 'C') {
            return (n + 1) / 2;
        } else {
            return (n + 1) / 2 + 1;
        }
    }

    // Move n discs from 'from' pole to 'to' pole using 'temp' pole (standard Tower of Hanoi)
    private static void hanoi(int n, char from, char to, char temp) {
        if (n == 0) return;
        hanoi(n - 1, from, temp, to);
        move(n, from, to);
        hanoi(n - 1, temp, to, from);
    }

    // Main method
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java RevesPuzzle <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        char from = 'A';
        char to = 'D';
        char temp1 = 'B';
        char temp2 = 'C';

        revesPuzzle(n, from, to, temp1, temp2);
    }
}
