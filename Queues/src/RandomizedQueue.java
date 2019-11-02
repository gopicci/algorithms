import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[1];
        n = 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < n; i++)
            copy[i] = a[i];

        a = copy;
    }


    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (n == a.length)
            resize(2*a.length);

        a[n] = item;
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        int r = StdRandom.uniform(n);
        Item el = a[r];

        for (int i = r; i < n - 1; i++)
            a[i] = a[i + 1];

        a[n - 1] = null;

        if (n > 0 && n == a.length/4)
            resize(a.length/2);

        n--;

        return el;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        int r = StdRandom.uniform(n);

        return a[r];

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private int i = n;
        private final int[] order;

        public RandomIterator() {
            order = new int[i];
            for (int j = 0; j < i; ++j) {
                order[j] = j;
            }
            StdRandom.shuffle(order);
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (i == 0)
                throw new NoSuchElementException();
            return a[order[--i]];
        }

    }


    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> rqueue = new RandomizedQueue<Integer>();
        rqueue.enqueue(1);
        rqueue.enqueue(2);
        rqueue.enqueue(3);
        rqueue.enqueue(4);
        rqueue.enqueue(5);
        rqueue.enqueue(6);
        rqueue.enqueue(7);
        rqueue.enqueue(8);
        Iterator<Integer> it = rqueue.iterator();
        while (it.hasNext()) {
            int elt = it.next();
            System.out.println(elt + " ");
        }

    }

}