public class InsertionSort {
    public static void sort(Comparable[] items) {
        int N = items.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(items[j], items[j - 1])) {
                    swap(items, j, j - 1);
                } else
                    break;
            }
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
        InsertionSort.sort(b);
        for (Integer t : b) {
            System.out.println(t);
        }
    }
}
