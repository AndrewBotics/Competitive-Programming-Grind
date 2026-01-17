import java.io.*;
import java.util.*;

public class SubarraySumI {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

		int count = 0;
		for (int i = 0, j = 0, cur = 0; i < n && j < n;) {
			cur += arr[j];
			if (cur == x) {
				count++;
				j++;
			}
			else if (cur > x) {
				cur -= arr[i];
				cur -= arr[j];
				i++;
			}
			else j++;
		}

		System.out.println(count);
	}
}