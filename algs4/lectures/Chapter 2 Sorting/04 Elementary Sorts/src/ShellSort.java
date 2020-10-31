public class ShellSort {

    public static void sort(Comparable[] items) {
        int N = items.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1; // 1, 4, 13, 40...

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(items[j], items[j - h]); j -= h) {
                    swap(items, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] items, int i, int j) {
        Comparable tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public static void main(String[] args) {
        String[] a = new String[] { "b", "a", "c" };
        Integer[] b = new Integer[] { 4, 3, 5, 7, 5, 4, 6, 78, 2 };
        ShellSort.sort(b);
        for (Integer t : b) {
            System.out.println(t);
        }
    }
}
