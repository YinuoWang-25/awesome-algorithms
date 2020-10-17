public class queue_using_array {
    private String[] s;
    private int head, tail;

    public queue_using_array(int capacity) {
        s = new String[capacity];
        head = -1;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public void enqueue(String item) {
        s[tail++] = item;
        if (isEmpty()) {
            head = 0;
        }
    }

    private void resize(int capacity) {

    }

    public String dequeue() {
        return "";
    }
}
