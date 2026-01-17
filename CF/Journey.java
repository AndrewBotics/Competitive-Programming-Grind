import java.io.*;
import java.util.*;

public class Journey {
    static List<Integer>[] cities;
    static boolean[] visited;
    static double ans = 0;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        cities = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) cities[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            cities[a].add(b);
            cities[b].add(a);
        }

        dfs(1, 0, 1.0);
        System.out.println(ans);
    }

    static void dfs(int node, int depth, double prob) {
        visited[node] = true;
        int children = 0;
        for (int nxt : cities[node]) {
            if (!visited[nxt]) children++;
        }

        if (children == 0) {
            ans += prob * depth;
            return;
        }

        for (int nxt : cities[node]) {
            if (!visited[nxt]) {
                dfs(nxt, depth + 1, prob / children);
            }
        }
    }
}
