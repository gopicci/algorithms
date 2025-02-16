public class Mergesort extends Helpers{

    private static final int CUTOFF = 7;
    public static Comparable[] aux;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // assertions to help debugging, java -ea to enable, java -da to disable
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) // i pointer exausted, just copy right side
                a[k] = aux[j++];
            else if (j > hi) // j pointer exausted, just copy left side
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) // main check
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        //if (hi <= lo) return;
        // Improvement 1: use insertion sort for small subarrays, less overhead 20% faster
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi);
            return;
        }
        //

        int mid = lo + (hi -lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        //if (!less(a[mid+1], a[mid])) return; // Improvement 2: stop merging if already sorted
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length -1 );
    }


}