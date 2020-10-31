public class QuickSortWithDuplicate {
    public static void sort(Comparable[] a) {
        shuffle();
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
          int cmp = a[i].compareTo(v);
          if (cmp < 0) swap(a, lt++, i++);
          else if (cmp > 0) swap(a, i gt--);
          else i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void swap(Comparable[] items, int i, int j) {
        Comparable tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
