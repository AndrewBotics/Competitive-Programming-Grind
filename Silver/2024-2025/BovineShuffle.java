// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class BovineShuffle {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new File("shuffle.out"));
		int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ct = 0;
        for (int i = 1; i<=n; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i<=n; i++){
            if (targets[targets[i]]==i) ct++;
        }
        pw.println(ct);
		pw.close();
	}
}
