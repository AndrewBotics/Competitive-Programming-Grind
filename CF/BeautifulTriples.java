import java.util.*;
import java.io.*;

public class BeautifulTriples {
    static class Triple {
        int x, y, z;
        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triple)) return false;
            Triple t = (Triple) o;
            return x == t.x && y == t.y && z == t.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            Map<Triple, Integer> cnt = new HashMap<>();
            long ans = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n - 2; i++) {
                int c = Integer.parseInt(st.nextToken());
                Triple triplet = new Triple(a, b, c);
                Triple[] mist = new Triple[3];
                mist[0] = new Triple(0, b, c);
                mist[1] = new Triple(a, 0, c);
                mist[2] = new Triple(a, b, 0);

                for (Triple trip : mist) {
                    ans += cnt.getOrDefault(trip, 0) - cnt.getOrDefault(triplet, 0);
                    cnt.put(trip, cnt.getOrDefault(trip, 0) + 1);
                }
                cnt.put(triplet, cnt.getOrDefault(triplet, 0) + 1);
                a = b;
                b = c;
            }

            sb.append(ans).append("\n");
        }
        pw.println(sb);
        pw.close();
    }
}
