import java.util.Random;

public class Shuffle {
    static Random rand = new Random();

    public static void shuffle(Object[] items) {
        int N = items.length;
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(i + 1);
            swap(items, i, r);
        }
    }

    private static void swap(Object[] items, int i, int j) {
        Object tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] b = new Integer[] { 4, 3, 5, 7, 5, 4, 6, 78, 2 };
        Shuffle.shuffle(b);
        for (Integer t : b) {
            System.out.println(t);
        }
    }
}
