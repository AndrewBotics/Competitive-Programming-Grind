import java.io.*;
import java.util.*;

public class CowCheckups {
    static class Pair implements Comparable<Pair> {
        long first, second;
        Pair(long f, long s) { first = f; second = s; }
        public int compareTo(Pair o) {
            if (first != o.first) return Long.compare(first, o.first);
            return Long.compare(second, o.second);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];

        @SuppressWarnings("unchecked")
        ArrayList<Pair>[] v = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) v[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            a[i] = fs.nextLong();
            if (v[(int)a[i]].isEmpty()) {
                v[(int)a[i]].add(new Pair(i, i));
            } else {
                long prev = v[(int)a[i]].get(v[(int)a[i]].size() - 1).second;
                v[(int)a[i]].add(new Pair(i, prev + i));
            }
        }

        for (int i = 1; i <= n; i++) b[i] = fs.nextLong();

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == b[i]) {
                ans += (long)n * (n + 1) / 2 - (long)i * (n - i + 1);
            }
            int x = (int)b[i];
            if (v[x].isEmpty()) continue;

            int itr = lowerBound(v[x], new Pair(n - i + 1, -1));
            int itr2 = lowerBound(v[x], new Pair(i + 1, -1));

            if (itr2 >= itr) ans += (long)(itr2 - itr) * (n - i + 1);
            itr = Math.min(itr, itr2);
            if (itr > 0) ans += v[x].get(itr - 1).second;

            itr = lowerBound(v[x], new Pair(n + 1 - i + 1, -1));
            if (itr >= itr2) ans += (long)(itr - itr2) * i;

            int tot = v[x].size();
            itr = Math.max(itr, itr2);
            if (tot > itr) {
                ans += (long)(tot - itr) * (n + 1);
                ans -= v[x].get(tot - 1).second - (itr > 0 ? v[x].get(itr - 1).second : 0);
            }
        }

        System.out.println(ans);
    }

    // Java equivalent of std::lower_bound for Pair list
    static int lowerBound(ArrayList<Pair> arr, Pair key) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr.get(mid).compareTo(key) < 0) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Fast input
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
