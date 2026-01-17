import java.io.*;
import java.util.*;

public class ConnectBarns {
    static ArrayList<Integer>[] graph;
    static int[] comp;
    static int compId = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for (int i=1; i<=n; i++) graph[i] = new ArrayList<>();

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            comp = new int[n+1];
            Arrays.fill(comp, -1);
            compId = 0;

            // DFS to find components
            for (int i=1; i<=n; i++) {
                if (comp[i] == -1) {
                    dfs(i, compId++);
                }
            }

            if (comp[1] == comp[n]) {
                out.println(0);
                continue;
            }

            // Build list of nodes for each component
            ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
            for (int i=0; i<compId; i++) comps.add(new ArrayList<>());
            for (int i=1; i<=n; i++) comps.get(comp[i]).add(i);

            for (ArrayList<Integer> list : comps) Collections.sort(list);

            // distance between two comps
            long ans = dist(comps.get(comp[1]), comps.get(comp[n]));
            ans = ans * ans;

            for (int k=0; k<compId; k++) {
                long d1 = dist(comps.get(comp[1]), comps.get(k));
                long d2 = dist(comps.get(k), comps.get(comp[n]));
                ans = Math.min(ans, d1*d1 + d2*d2);
            }

            out.println(ans);
        }
        out.close();
    }

    static void dfs(int u, int id) {
        comp[u] = id;
        for (int v : graph[u]) {
            if (comp[v] == -1) dfs(v, id);
        }
    }

    // min |i-j| between sorted lists
    static long dist(List<Integer> a, List<Integer> b) {
        int i=0, j=0;
        long best = Long.MAX_VALUE;
        while (i<a.size() && j<b.size()) {
            best = Math.min(best, Math.abs((long)a.get(i) - b.get(j)));
            if (a.get(i) < b.get(j)) i++;
            else j++;
        }
        return best;
    }
}
