import java.util.*;
import java.io.*;
public class guesstheanimal {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("guess.in"));
		PrintWriter pw = new PrintWriter(new File("guess.out"));
		int n = s.nextInt();
		ArrayList<ArrayList<String>> traits = new ArrayList<ArrayList<String>>();
		for (int a=0; a<n; a++) {
			ArrayList<String> type = new ArrayList<String>();
			String name = s.next();
			int i = s.nextInt();
			for (int b = 0; b < i; b++) {
				String c = s.next();
				type.add(c);
			}
			traits.add(type);
		}
		
		int max = 0;
		for (int a=0; a < n-1; a++) {
			for (int b=a+1; b<n; b++) {
				int count = 0;
				for (int c = 0; c < traits.get(a).size(); c++) {
					if (traits.get(b).contains(traits.get(a).get(c))) {
						count++;
					}
				}
				if (count + 1 > max) {
					max = count + 1;
				}
			}
		}
		pw.println(max);
		pw.close();
	}
}