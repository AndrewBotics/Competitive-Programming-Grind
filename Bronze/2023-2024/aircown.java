import java.io.*;
import java.util.*;

public class aircown {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int[] cows = new int[n];
		for (int i = 0; i<n; i++) cows[i] = s.nextInt();
		for (int i = 0; i<n; i++) cows[i] -= s.nextInt();
		int ret = 0;
		//pw.println(Arrays.toString(cows));
		while (checkForPositives(cows)){
			int ind = -1;
			int ind2 = -1;
			for (int i = 0; i<n && ind==-1; i++){
				if (cows[i]!=0) ind = i;
			}
			int sub = Integer.MAX_VALUE;
			if (cows[ind]<0) sub *= -1;
			for (int i = ind; i<n && ind2==-1; i++){
				if (cows[ind]>0 && cows[i]>0) sub = Math.min(sub, cows[i]);
				else if (cows[ind]<0 && cows[i]<0) sub = Math.max(sub, cows[i]);
				else ind2 = i;
			}
			if (ind2 == -1) ind2 = n;
			for (int i = ind; i<ind2; i++){
				cows[i] -= sub;
			}
			ret+=Math.abs(sub);
			//pw.println(Arrays.toString(cows));
		}
		pw.println(ret);
		pw.close();
	}
	static boolean checkForPositives(int[] cows){
		for (int i : cows) if (i!=0) return true;
		return false;
	}
}