import java.io.*;
import java.util.*;

public class GraphComp {
    static List<Integer>[] adj_f, adj_g;
    static int[] component_id;
    static boolean[] used;
    static Map<Long, Boolean> invalid_edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int test_num = Integer.parseInt(br.readLine());
        for (int t = 0; t < test_num; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            adj_f = new ArrayList[n];
            adj_g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj_f[i] = new ArrayList<>();
                adj_g[i] = new ArrayList<>();
            }

            // read F edges
            for (int i = 0; i < m1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                adj_f[u].add(v);
                adj_f[v].add(u);
            }

            // read G edges
            for (int i = 0; i < m2; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                adj_g[u].add(v);
                adj_g[v].add(u);
            }

            int g_comps = 0;
            component_id = new int[n];
            used = new boolean[n];

            // DFS on G
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    g_comps++;
                    dfs_g(i, g_comps);
                }
            }

            // count invalid edges in F
            int invalid = 0;
            invalid_edges = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int u : adj_f[i]) {
                    if (component_id[i] != component_id[u]) {
                        invalid++;
                        long key = encode(i, u);
                        invalid_edges.put(key, true);
                    }
                }
            }

            // DFS on F (ignoring invalid edges)
            int f_comps = 0;
            Arrays.fill(used, false);
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    f_comps++;
                    dfs_f(i);
                }
            }

            out.println(invalid / 2 + (f_comps - g_comps));
        }

        out.close();
    }

    static void dfs_g(int node, int c) {
        component_id[node] = c;
        used[node] = true;
        for (int u : adj_g[node]) {
            if (!used[u]) dfs_g(u, c);
        }
    }

    static void dfs_f(int node) {
        used[node] = true;
        for (int u : adj_f[node]) {
            long key = encode(node, u);
            if (!used[u] && !invalid_edges.containsKey(key)) {
                dfs_f(u);
            }
        }
    }

    // encode an undirected edge as a long key
    static long encode(int u, int v) {
        if (u > v) { int tmp = u; u = v; v = tmp; }
        return ((long) u << 32) | (v & 0xffffffffL);
    }
}
