import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    // inner class as Itearator
    private class ListIterator implements Iterator<Item> {

        private Node current = first;
    
        @Override
        public boolean hasNext() {
            return current != null;
        }
    
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    // inner class as Node
    private class Node {
    
        private Item item;
        private Node next;
        private Node prev;
    
        public Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private Node first, last;
    private int size;

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("can not add null to first");
        Node oldFirst = first;
        first = new Node(item);
        if (oldFirst == null) last = first;
        else  {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("can not add null to last");
        Node oldLast = last;
        last = new Node(item);
        if (oldLast == null) first = last;
        else {
            last.prev = oldLast;
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("remove first underflow");
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("remove last underflow");
        Item item = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();
        System.out.println(deque.isEmpty());
    }
}