public class QuickTest {
    public static void main(String[] args) {
        String s = "abcbcccbbaaac";
        char[] c = s.toCharArray();
        Character[] a = new Character[c.length];
        int i = 0;
        for (char value : c)
            a[i++] = Character.valueOf(value);
        Quick3way.sort(a);
        for (Character ch : a)
            System.out.println(ch);

    }
}