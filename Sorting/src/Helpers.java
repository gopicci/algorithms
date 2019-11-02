import java.util.Comparator;

public class Helpers {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Comparator versions, to decouple odering rules from data type (student has multiple ordering rules, date has 1)
    public static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static boolean isSorted(Comparable[] a, int i, int j) {
        for (int k = i; k < j; k++)
            if (less(a[k], a[k-1])) return false;
        return true;
    }

}