public  class UnorderedMaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;   // pq[i] = ith element on pq
  private int N;    // number of elements on pq

  public UnorderedMaxPQ(int capacity) {
    pq = (Key[]) mew Comparable[capacity];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void insert(Key x) {
    pq[N++] = x;
  }

  public Key delMax() {
    int max = 0;
    for (int i = 0; i < N; i++) {
      if (less(max, i)) max = i;
    }
    swap(max, N  - 1);
    return pq[--N];
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