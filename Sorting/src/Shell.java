import java.util.Comparator;

public class Shell extends Helpers{

    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...

        while (h >= 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);

            h = h/3;
        }
    }

    // Comparator version
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;

        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...

        while (h >= 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(comparator, a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);

            h = h/3;
        }
    }

}