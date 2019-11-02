import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.first == null;
    }

    // return the number of items on the deque
    public int size() {
        return this.n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (this.first == null) {
            this.first = new Node();
            this.first.item = item;
            this.last = this.first;
        } else {
            Node newfirst = new Node();
            newfirst.item = item;
            newfirst.next = this.first;
            this.first.prev = newfirst;
            this.first = newfirst;
        }
        this.n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (this.last == null) {
            this.last = new Node();
            this.last.item = item;
            this.first = this.last;
        } else {
            Node newlast = new Node();
            newlast.item = item;
            newlast.prev = this.last;
            this.last.next = newlast;
            this.last = newlast;
        }
        this.n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();

        Item ret = this.first.item;

        this.first = this.first.next;
        if (this.first != null)
            this.first.prev = null;
        else
            this.last = null;
        --this.n;

        return ret;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();

        Item ret = this.last.item;

        this.last = this.last.prev;
        if (this.last != null)
            this.last.next = null;
        else
            this.first = null;
        --this.n;

        return ret;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
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
            if (current == null)
                throw new java.util.NoSuchElementException();

            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    // unit testing (required)
    public static void main(String[] args) {


        Deque<Integer> d = new Deque<>();

        d.addFirst(1);
        System.out.println(d.removeLast());
        d.addFirst(1);
        System.out.println(d.removeLast());

        d.addFirst(1);
        System.out.println(d.removeLast());
        d.addFirst(2);
        System.out.println(d.removeLast());

        d.addFirst(7);
        d.addLast(5);
        d.addLast(8);
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        d.addLast(5);
        d.addLast(8);


        for (Integer i : d) {
            System.out.println(i);
        }



        System.out.println(d.isEmpty());
        System.out.println(d.size());

    }

}