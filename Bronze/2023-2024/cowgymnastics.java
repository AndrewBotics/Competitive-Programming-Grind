import java.io.*;
import java.util.*;

public class cowgymnastics {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("gymnastics.in"));
		PrintWriter pw = new PrintWriter(new File("gymnastics.out"));
		int n = s.nextInt();
		int c = s.nextInt();
		List<String> totals = new ArrayList<>();
		String[] ranks = new String[c];
		for (int j = 0; j<c; j++) ranks[j] = s.next();
		for (int i = 0; i<c-1; i++){
			for (int j = i+1; j<c; j++){
				totals.add(ranks[i]+" "+ranks[j]);
			}
		}
		//pw.println(totals);
		for (int i = 1; i<n; i++){
			List<String> tot2 = new ArrayList<>();
			ranks = new String[c];
			for (int j = 0; j<c; j++) ranks[j] = s.next();
			for (int j = 0; j<c-1; j++){
				for (int k = j+1; k<c; k++){
					if (totals.contains(ranks[j]+" "+ranks[k])) tot2.add(ranks[j]+" "+ranks[k]);
				}
			}
			totals = tot2;
			//pw.println(totals);
		}
		pw.println(totals.size());
		pw.close();
	}
}