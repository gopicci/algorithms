public class Insertion extends Helpers {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(Comparable[] a, int m, int n) {
        if (m >= n) return;

        for (int i = m; i < n; i++)
            for (int j = i; j > m; j--)
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else
                    break;
    }

}