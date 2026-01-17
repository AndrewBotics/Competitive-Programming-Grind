import java.util.*;

public class cowschool {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] x = new int[n];
		for (int i=0; i<n; i++) {
			x[i]=s.nextInt();
		}
		Arrays.sort(x);
		long gain = -1L;
		int fee = 0;
		
		for (int z=n-1; z>=0; z--) {
			long k = (long)(n-z)*(long)x[z];
			if (k >= gain) {
				gain = k;
				fee = x[z];
			}
		}
		System.out.println(gain+" "+fee);
	}
}