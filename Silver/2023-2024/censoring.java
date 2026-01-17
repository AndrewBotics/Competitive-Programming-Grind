import java.io.*;
import java.util.*;

public class censoring {
	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(System.in);
		//PrintWriter pw = new PrintWriter(System.out);
		Scanner s = new Scanner(new File("censor.in"));
		PrintWriter pw = new PrintWriter(new File("censor.out"));

		char[] m = s.next().toCharArray();
		List<Character> mag = new ArrayList<>();
		for (char mm : m) mag.add(mm);
		char[] cen = s.next().toCharArray();

		//pw.println(mag);
		//pw.println(Arrays.toString(cen));

		int ind = popIndex(mag, cen);
		while (ind != -1){
			mag = popHere(mag, cen, ind);
			ind = popIndex(mag, cen);
		}
		//pw.println(mag);
		for (int i = 0; i<mag.size(); i++) pw.print(mag.get(i));
		pw.close();
	}
	public static int popIndex(List<Character> mag, char[] cen){
		int mSize = mag.size();
		int cSize = cen.length;
		for (int i = 0; i<mSize-cSize; i++){
			boolean popHere = true;
			for (int j = 0; j<cSize && popHere; j++){
				if (mag.get(i+j)!=cen[j]) popHere = false;
			}
			if (popHere) return i;
		}
		return -1;
	}
	public static List<Character> popHere(List<Character> mag, char[] cen, int ind){
		int mSize = mag.size();
		int cSize = cen.length;
		for (int i = 0; i<mSize; i++){
			if (i==ind){
				for (int j = 0; j<cSize; j++){
					mag.remove(i);
				}
				return mag;
			}
		}
		return mag;
	}
}
