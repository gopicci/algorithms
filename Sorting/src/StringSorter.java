import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class StringSorter {
    public static void main(String[] args) {
        String[] a = StdIn.readStrings(args[0]);
        Quick.sort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}