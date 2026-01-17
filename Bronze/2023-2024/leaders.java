import java.io.*;
import java.util.*;

public class leaders {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		char[] cows = s.next().toCharArray();
		int[] ind = new int[n];
		for (int i = 0; i<n; i++) ind[i] = s.nextInt()-1;
		int maxg = -1, ming = -1, maxh = -1, minh = -1;
		for (int i = 0; i<n; i++){
			if (cows[i]=='G') {
				maxg = i;
				if (ming==-1) ming = i;
			}
			else {
				maxh = i;
				if (minh==-1) minh = i;
			}
		}

		int ans = 0;
		if (ind[ming] >= maxg){
			for (int i = 0; i<ming; i++){
				if (cows[i] == 'H' && ind[i] >= ming) ans++;
			}
		}
		if (ind[minh] >= maxh){
			for (int i = 0; i<minh; i++){
				if (cows[i] == 'G' && ind[i] >= minh) ans++;
			}
		}
		if ((ind[ming] >= maxg || (ming <= minh && ind[ming] >= maxh)) && (ind[minh] >= maxh || (minh <= ming && ind[minh] >= maxg))) ans++;
		pw.println(ans);
		pw.close();
	}
}