public class QuickSort {
    public static void sort(Comparable[] a) {
        shuffle();
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
      int i = lo, j = hi + 1;
      while (true) {
        while (less(a[++i], a[lo]))
          if (i == hi) break;
        while (less(a[lo], a[--j]))
          if (j == lo) break;
        if (i >= j) break;
        swap(a, i , j);
      }
      swap(a, lo, j);
      return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] items, int i, int j) {
        Comparable tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
