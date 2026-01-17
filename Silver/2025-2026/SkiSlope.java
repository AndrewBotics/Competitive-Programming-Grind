import java.io.*;
import java.util.*;

public class SkiSlope {
    static final int MAXC = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        int[] d = new int[N];
        int[] e = new int[N];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken()) - 1;
            d[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
        }

        long[] E = new long[N];
        E[0] = 0;
        for (int i = 1; i < N; i++) {
            E[i] = E[p[i]] + e[i];
        }

        // topC[i] = top MAXC difficulties along path to root
        List<Integer>[] topC = new ArrayList[N];
        topC[0] = new ArrayList<>(Collections.nCopies(MAXC, -1));
        for (int i = 1; i < N; i++) {
            topC[i] = new ArrayList<>(topC[p[i]]);
            topC[i].add(d[i]);
            topC[i].sort(Collections.reverseOrder());
            if (topC[i].size() > MAXC) {
                topC[i] = new ArrayList<>(topC[i].subList(0, MAXC));
            }
        }

        // DE[c][i] = (difficulty, enjoyment)
        Pair[][] DE = new Pair[MAXC][N];
        for (int c = 0; c < MAXC; c++) {
            for (int i = 0; i < N; i++) {
                DE[c][i] = new Pair(topC[i].get(c), E[i]);
            }
            Arrays.sort(DE[c], Comparator.comparingInt(a -> a.diff));
            for (int i = 1; i < N; i++) {
                DE[c][i].enj = Math.max(DE[c][i].enj, DE[c][i - 1].enj);
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int idx = lowerBound(DE[C], new Pair(S + 1, Long.MIN_VALUE));
            out.println(DE[C][idx - 1].enj);
        }

        out.close();
    }

    // custom pair class
    static class Pair {
        int diff;
        long enj;
        Pair(int diff, long enj) {
            this.diff = diff;
            this.enj = enj;
        }
    }

    // lower_bound equivalent in Java
    static int lowerBound(Pair[] arr, Pair key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid].diff < key.diff) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
