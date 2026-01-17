import java.io.*;
import java.util.*;

public class SubSum {
	private static List<int[]>[] adj;
	private static long[] pref;
	private static boolean[] visited;
	private static boolean valid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		pref = new long[n + 1];
		adj = new ArrayList[n + 1];
		valid = true;

		for (int i = 0; i <= n; i++) { adj[i] = new ArrayList<>(); }
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			adj[l - 1].add(new int[] {r, s});
			adj[r].add(new int[] {l - 1, -s});
		}

		for (int i = 0; i <= n; i++) {
			if (visited[i]) { continue; }
			pref[i] = 0;
			dfs(i);
			if (!valid) {
				System.out.println("NO");
				return;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		for (int i = 1; i <= n; i++) { sb.append(pref[i] - pref[i - 1] + " "); }
		System.out.println(sb);
	}

	private static void dfs(int s) {
		if (visited[s]) { return; }
		visited[s] = true;

		for (int[] u : adj[s]) {
			int v = u[0];
			long val = pref[s] + u[1];

			if (!visited[v]) {
				pref[v] = val;
				dfs(v);
				if (!valid) { return; }
			} else if (pref[v] != val) {
				valid = false;
				return;
			}
		}
	}
}