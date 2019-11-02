import java.util.Comparator;
// Comparator decouples odering rules from data type (student has multiple ordering rules, date has 1)

public class Student {
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_BIRTH = new ByBirth();

    public final String name;
    public final Date birth;

    public Student(String n, Date b) {
        name = n;
        birth = b;
    }

    private static class ByName implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.name.compareTo(w.name);
            //uses string compareTo but don't have to be a comparable, could be v - w or something
        }
    }

    private static class ByBirth implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.birth.compareTo(w.birth);
            //uses date compareTo
        }
    }

}