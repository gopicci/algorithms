public class MergesortBottomUp extends Helpers {

    // non recursive version or Mergesort

    private static Comparable[] aux;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // same as mergesort

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

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)
            for (int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz+sz-1, N-1));


    }



}