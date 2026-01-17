import java.io.*;
import java.util.*;

public class TwoVals {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int[] a = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(a[0], 1);
        for (int i = 1; i < n; ++i) {
            if (map.containsKey(x - a[i])) {
                System.out.println((i + 1) + " " + map.get(x - a[i]));
                return;
            }
            map.put(a[i], i + 1);
        }
        System.out.println("IMPOSSIBLE");
    }
}
