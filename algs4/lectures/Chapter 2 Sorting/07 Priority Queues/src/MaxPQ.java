public class MaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;   // pq[i] = ith element on pq
  private int N;    // number of elements on pq

  public MaxPQ(int capacity) {
    pq = (Key[]) mew Comparable[capacity + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void insert(Key x) {
  }

  public Key delMax() {
  }

  private void swim(int k) {

  }

  private void sink(int k) {

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