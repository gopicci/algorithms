import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {

        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        int outCount = Integer.parseInt(args[0]);
        int inCount = 0;

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item != null && item.length() > 0) {
                queue.enqueue(item);
                inCount++;
            }
        }

        if (inCount < outCount) {
            throw new NoSuchElementException();
        }

        while (outCount > 0) {
            StdOut.println(queue.dequeue());
            outCount--;
        }
    }
}