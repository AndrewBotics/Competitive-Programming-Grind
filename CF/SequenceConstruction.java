import java.util.*;
import java.io.*;

public class SequenceConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Integer> a = new ArrayList<>();
            int x = 0;

            for (int i = 0; i < 5; i++) {
                if ((k & (1 << i)) != 0) {
                    int val = (1 << (1 << i)) - 1;
                    a.add(val);
                    x += val;
                }
            }

            //System.out.println(a);
            int d = m - x;
            List<Integer> b = new ArrayList<>();
            int flag = 0;

            if (d < 0) {
                flag = 1;
            } else if (d >= 2) {
                if (d % 2 == 0) {
                    b.add(d / 2);
                    b.add(d / 2);
                } else {
                    b.add(1);
                    b.add(2);
                    b.add((d - 3) / 2);
                    b.add((d - 3) / 2);
                }
            } else if (d==1) {
                if (!a.isEmpty() && a.get(0) == 1) {
                    a.set(0, 2);
                } else {
                    flag = -1;
                }
            }

            if (flag != 0) {
                out.append("-1\n");
            } else {
                out.append(a.size() + b.size()).append("\n");
                for (int i : a) out.append(i).append(" ");
                for (int i : b) out.append(i).append(" ");
                out.append("\n");
            }
        }

        System.out.print(out.toString());
    }
}
