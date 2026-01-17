// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class logicalmoos2 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int q = s.nextInt();
		List<String> terms = new ArrayList<>();
		for (int i = 0; i<n; i++) terms.add(s.next());
		for (int i = 0; i<q; i++){
			int left = s.nextInt();
			int right = s.nextInt();
			String want = s.next();
			List<String> curr = new ArrayList<>();
			for (int j = 0; j<n; j++){
				if (j==left-1) curr.add("true");
				else if (!(left-1<j && j<right)) curr.add(terms.get(j));
			}
			//pw.println(curr);
			boolean check = evaluate(curr, want);

			if (check) pw.print("Y");
			else {
				curr = new ArrayList<>();
				for (int j = 0; j<n; j++){
					if (j==left-1) curr.add("false");
					else if (!(left-1<j && j<right)) curr.add(terms.get(j));
				}
				//pw.println(curr);
				boolean check2 = evaluate(curr, want);
				if (check2) pw.print("Y");
				else pw.print("N");
				//pw.println(check || check2);
			}
		}
		pw.close();
	}
	static boolean evaluate(List<String> curr, String want){
		int jj = curr.size();
		while(curr.contains("and")){
			int c = curr.indexOf("and");
			curr.remove(c);
			if (curr.get(c-1).equals("true")&&curr.get(c).equals("true")){
				curr.set(c-1, "true");
			}
			else{
				curr.set(c-1, "false");
			}
			curr.remove(c);
		}
		while(curr.contains("or")){
			int c = curr.indexOf("or");
			curr.remove(c);
			if (curr.get(c-1).equals("true")||curr.get(c).equals("true")){
				curr.set(c-1, "true");
			}
			else{
				curr.set(c-1, "false");
			}
			curr.remove(c);
		}
		return curr.get(0).equals(want);
	}
}
