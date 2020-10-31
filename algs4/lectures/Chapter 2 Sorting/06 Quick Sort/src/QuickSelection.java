public class QuickSelect {
    public static Comparable select(Comparable[] a, int k) {
        shuffle();
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
          int j = partition(a, lo, hi);
          if (j < k) lo = j + 1;
          else if (j > k) hi = j - 1;
          else return a[k];
        }
        return a[k];
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
