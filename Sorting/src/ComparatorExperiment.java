import edu.princeton.cs.algs4.StdOut;

public class ComparatorExperiment {

    public static void main(String[] args) {
        Student[] a = new Student[5];
        a[0] = new Student("Mark", new Date(1, 2, 1980));
        a[1] = new Student("Bob", new Date(2, 12, 1990));
        a[2] = new Student("Lara", new Date(25, 5, 1983));
        a[3] = new Student("Zeus", new Date(12, 2, 1990));
        a[4] = new Student("Alastor", new Date(4, 5, 1983));

        //Shell.sort(a, Student.BY_NAME);
        Shell.sort(a, Student.BY_BIRTH);

        for (int i = 0; i < 5; i++) {
            StdOut.println(a[i].name + " - " + Integer.toString(a[i].birth.day) + "/" + Integer.toString(a[i].birth.month) + "/" + Integer.toString(a[i].birth.year));
        }
    }
}