import java.util.*;
import java.io.*;

class dontbelast {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("notlast.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("notlast.out"));
		String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		int n = s.nextInt();
		int[] results = new int[7];
		for (int i = 0; i < n; i++) {
			results[Arrays.asList(names).indexOf(s.next())] += s.nextInt();
		}
		int min = results[0];
		for (int i : results){
			min = Math.min(min, i);
		}
		int temp = 1000000000;
		for (int i = 0; i < 7; i++) {
			if (results[i]-min>0) temp = Math.min(temp, results[i]-min);
		}
		List<String> ans = new ArrayList<String>();
		for (int i = 0; i<7; i++) {
			if (results[i]==temp+min) ans.add(names[i]);
		}
		if (ans.size() !=1) pw.println("Tie");
		else pw.println(ans.get(0));
		pw.close();
	}
}