public class Date implements Comparable<Date> {

    public final int day, month, year;

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public int compareTo(Date o) {
        if (this.year < o.year) return -1;
        if (this.year > o.year) return +1;
        if (this.month < o.month) return -1;
        if (this.month > o.month) return +1;
        if (this.day < o.day) return -1;
        if (this.day > o.day) return +1;
        return 0;
    }

}