import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    Node first, last, iter;
    int size;

    private class Node {
        Item value;
        Node next;
        Node prev;

        public Node(Item value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = current.value;
                current = current.next;
                return item;
            }
        }
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        iter = first;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("add null to first");
        }
        Node oldFirst = first;
        first = new Node(item);
        if (oldFirst == null) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("add null to last");
        }
        Node oldLast = last;
        last = new Node(item);
        if (oldLast == null) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size() == 0) {
            throw new NoSuchElementException("remove first in empty deque");
        }
        Item value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size() == 0) {
            throw new NoSuchElementException("remove last in empty deque");
        }
        Item value = last.value;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return value;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.print(deque.removeLast());
            else
                deque.addFirst(s);
        }
    }

}
