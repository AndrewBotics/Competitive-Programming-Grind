import java.util.*;

public class BeautPermII {
    static int n;
    static List<Integer> v = new ArrayList<>();
    static TreeSet<Integer> s = new TreeSet<>();

    public static void f() {
        if (v.size() == n) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.exit(0);
        }
        for (int i : new ArrayList<>(s)) {
            if (v.isEmpty() || Math.abs(v.get(v.size()-1) - i) > 1) {
                v.add(i);
                s.remove(i);
                f();
                s.add(i);
                v.remove(v.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) s.add(i);
        f();
        System.out.println("NO SOLUTION");
    }
}
