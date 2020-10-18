public class SelectSort {
    public static void sort(Comparable[] items) {
        int N = items.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(items[j], items[min]))
                    min = j;
            }
            swap(items, i, min);
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
        SelectSort.sort(b);
        for (Integer t : b) {
            System.out.println(t);
        }
    }
}
