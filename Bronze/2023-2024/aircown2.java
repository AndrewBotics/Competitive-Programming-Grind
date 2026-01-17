import java.util.*;
import java.io.*;

class aircown2 {
	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(new File("problem.in"));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] cows = new int[n][3];
		int[][] cons = new int[m][4];
		int max = 0;
		for (int i = 0; i<n; i++){
			for (int j = 0; j<3; j++) cows[i][j] = s.nextInt();
			max = Math.max(max, cows[i][1]);
		}
		for (int i = 0; i<m; i++){
			for (int j = 0; j<4; j++) cons[i][j] = s.nextInt();
			max = Math.max(max, cons[i][1]);
		}
		
		int[] needs = new int[max];
		for (int i = 0; i<n; i++){
			for (int j = cows[i][0]; j<=cows[i][1]; j++) needs[j-1] = Math.max(needs[j-1], cows[i][2]);
		}
		List<Integer> x = new ArrayList<Integer>();
		Arrays.sort(cons, (a, b) -> Integer.compare(b[3], a[3]));
		
		int[] track = new int[m];
		for (int k = 0; k<Math.pow(2, m)-1; k++){
			check(track);
			int[] cows2 = new int[max];
			for (int i=0; i<m; i++){
				if (track[i] == 1){
					for (int j = cons[i][0]; j<=cons[i][1]; j++) cows2[j-1] += cons[i][2];
				}
			}
			int smol = 0;
			for (int i=0; i<max; i++){
				if (cows2[i]<needs[i]) smol++;
			}
			if (smol == 0){
				int ret = 0;
				for (int i = 0; i<m; i++) if (track[i] == 1) ret += cons[i][3];
				x.add(ret);
			}
		}
		Collections.sort(x);
		System.out.println(x.get(0));
	}
	public static void check(int[] a){
		a[a.length-1]++;
		for (int i = a.length-1; i>=0; i--){
			if (a[i] == 2){
				a[i] = 0;
				a[i-1]++;
			}
		}
	}
}