import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



public class UF {

    private int[] id;    // access to component id (site indexed)
    private int count;   // number of components
    private QuickFindUF QuickFind;
    private QuickUnionUF QuickUnion;
    private WeightedQuickUnionUF WeightedQuickUnion;
    private WeightedQuickUnionPathCompressionUF WeightedQuickUnionPathCompression;

    public UF(int N)
    {   // Initiaize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        QuickFind = new QuickFindUF(count);
        QuickUnion = new QuickUnionUF(count);
        WeightedQuickUnionPathCompression = new WeightedQuickUnionPathCompressionUF(count);
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        //return QuickFind.connected(p, q);
        //return QuickUnion.connected(p, q);
        //return WeightedQuickUnion.connected(p, q);
        return WeightedQuickUnionPathCompression.connected(p, q);
    }


    public void union(int p, int q)
    {
        //QuickFind.union(p, q);
        //QuickUnion.union(p, q);
        //WeightedQuickUnion.union(p, q);
        WeightedQuickUnionPathCompression.union(p, q);
    }

    public static void main(String[] args) {

        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }

    }


}