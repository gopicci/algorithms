import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortingTest {
    public static void main(String[] args) {
        int N = Integer.parseInt("");
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        MergesortBottomUp.sort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}