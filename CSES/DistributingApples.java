import java.io.*;
import java.util.*;

public class DistributingApples {
	static final long MOD = (long)1e9 + 7;
	static final int MAXN = (int)2e6;

	static long[] fac = new long[MAXN];
	static long[] inv = new long[MAXN];

	/**
	 * Computes x^n modulo m in O(log p) time.
	 * See also: https://usaco.guide/gold/modular
	 */
	static long binpow(long x, long n, long m) {
		x %= m;
		long res = 1;
		while (n > 0) {
			if (n % 2 == 1) { res = res * x % m; }
			x = x * x % m;
			n /= 2;
		}
		return res;
	}

	static long binom(int n, int k) { return fac[n] * inv[k] % MOD * inv[n - k] % MOD; }

	public static void main(String[] args) throws IOException {
		fac[0] = fac[1] = 1;
		for (int i = 2; i < MAXN; i++) { fac[i] = i * fac[i - 1] % MOD; }

		inv[0] = 1;
		// Calculate the modular inverse with exponentiation
		inv[MAXN - 1] = binpow(fac[MAXN - 1], MOD - 2, MOD);
		// Calculate the modular inverse with factorial definition
		for (int i = MAXN - 2; i > 0; i--) { inv[i] = (i + 1) * inv[i + 1] % MOD; }

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		System.out.println(binom(n + m - 1, n - 1));
	}
}