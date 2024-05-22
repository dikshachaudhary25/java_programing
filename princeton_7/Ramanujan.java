import java.util.HashSet;
import java.util.Set;

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        Set<Long> cubes = new HashSet<>();
        for (long i = 1; i * i * i < n; i++) {
            long diff = n - i * i * i;
            long cbrt = (long) Math.cbrt(diff);
            if (cbrt * cbrt * cbrt == diff && !cubes.contains(diff)) {
                cubes.add(i * i * i);
                if (cubes.size() > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
