class StackUsingList {
    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
    }

    public String pop() {
        if (isEmpty())
            return "";
        String item = first.item;
        first = first.next;
        return item;
    }

}