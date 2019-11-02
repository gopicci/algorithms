import edu.princeton.cs.algs4.StdOut;

public class ComparableExperiment {

    public static void main(String[] args) {
        Date[] a = new Date[5];
        a[0] = new Date(1, 2, 1980);
        a[1] = new Date(2, 12, 1990);
        a[2] = new Date(25, 5, 1983);
        a[3] = new Date(12, 2, 1990);
        a[4] = new Date(4, 5, 1983);

        Insertion.sort(a);

        for (int i = 0; i < 5; i++) {
            StdOut.println(Integer.toString(a[i].day) + "/" + Integer.toString(a[i].month) + "/" + Integer.toString(a[i].year));
        }
    }
}