import java.io.*;
import java.util.*;

public class AppleDiv {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] elem = new long[n];
		for (int i = 0; i<n; i++) elem[i] = s.nextLong();
		System.out.println(solve(0, elem, 0, 0, n));
	}
	public static long solve(int idx, long[] arr, long sum1, long sum2, int n) {
        if (idx == n) return Math.abs(sum1 - sum2);
        long choose = solve(idx + 1, arr, sum1 + arr[idx], sum2, n);
        long notChoose = solve(idx + 1, arr, sum1, sum2 + arr[idx], n);
        return Math.min(choose, notChoose);
    }
}