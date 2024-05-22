public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }
        int[] aux = new int[a.length];
        return mergeSortAndCount(a, aux, 0, a.length - 1);
    }

    private static long mergeSortAndCount(int[] a, int[] aux, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSortAndCount(a, aux, left, mid);
        count += mergeSortAndCount(a, aux, mid + 1, right);
        count += mergeAndCount(a, aux, left, mid, right);
        return count;
    }

    private static long mergeAndCount(int[] a, int[] aux, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            aux[i] = a[i];
        }
        int i = left, j = mid + 1, k = left;
        long count = 0;
        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            a[k++] = aux[i++];
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int maxSwaps = (int) Math.min(k, n - 1 - i);
            if (maxSwaps > 0) {
                k -= maxSwaps;
                int temp = result[i + maxSwaps];
                for (int j = i + maxSwaps; j > i; j--) {
                    result[j] = result[j - 1];
                }
                result[i] = temp;
            }
        }
        return result;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] permutation = generate(n, k);
        for (int num : permutation) {
            System.out.print(num + " ");
        }
    }
}
