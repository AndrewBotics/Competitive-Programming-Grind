import java.io.*;
import java.util.*;

public class outofplace {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("outofplace.in"));
		PrintWriter pw = new PrintWriter("outofplace.out");
		int n = s.nextInt();
		int[] x = new int[n];
		for (int i = 0; i<n; i++) x[i] = s.nextInt();
		int[] y = x.clone();
		Arrays.sort(y);
		int ret = 0;
		for (int i = 0; i<n; i++){
			if (x[i]!=y[i]) ret++;
		}
		pw.println(ret-1);
		pw.close();
	}
}
