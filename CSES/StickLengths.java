// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class StickLengths {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] sticks = new int[n];
		for (int i = 0; i<n; i++) {
			sticks[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sticks);
		int mid = (int) sticks.length/2;
		long sum = 0;
		for (long stick : sticks){
			sum += Math.abs(stick-sticks[mid]);
		}
		System.out.println(sum);

		pw.close();
	}
}
