import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    public RandomizedQueue() {
        // cannot create object array
        items = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("can not enqueue null");
        if (size == items.length) resize(2 * items.length);
        items[size++] = item;
        if (size > 1) shuffle();
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("can not dequeue on empty queue");
        if (size == items.length / 4) resize(items.length / 2);
        shuffle();
        Item item = items[size-1];
        items[size-1] = null;
        size--;
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("can not sample on empty queue");
        return items[StdRandom.uniform(size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // helper function to resize the array to size of capacity
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    private void shuffle() {
        int randomIndex = StdRandom.uniform(size);
        Item temp = items[randomIndex];
        items[randomIndex] = items[size-1];
        items[size-1] = temp;
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i;
        private int[] randomIndices;
        public ArrayIterator() {
            i = 0;
            randomIndices = new int[size];
            for (int j = 0; j < size; j++) {
                randomIndices[j] = j;
            }
            StdRandom.shuffle(randomIndices);
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[randomIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // Unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());
        for (Integer i : queue) {
            System.out.println(i);
        }
        System.out.println("sample:" + queue.sample());
        System.out.println("dequeue");
        while (!queue.isEmpty()) System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }
}