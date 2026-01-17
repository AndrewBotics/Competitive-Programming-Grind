// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class logicalmoos {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int q = s.nextInt();
		List<String> terms = new ArrayList<>();
		for (int i = 0; i<n; i++) terms.add(s.next());
		String[][] endworks = new String[n+1][2];
		for (int i = 1; i<=n; i+=2){
			List<String> temp = new ArrayList<>();
			for (int j = 0; j<i; j++) temp.add(terms.get(j));
			endworks[i][0] = evaluate(temp);
		}
		for (int i = 1; i<=n; i+=2){
			List<String> temp = new ArrayList<>();
			for (int j = i-1; j<n; j++) temp.add(terms.get(j));
			endworks[i][1] = evaluate(temp);
		}
		//pw.println(Arrays.deepToString(endworks));
		for (int i = 0; i<q; i++){
			int left = s.nextInt();
			int right = s.nextInt();
			String want = s.next();
			List<String> curr = new ArrayList<>();
			if (left>=3){
				curr.add(endworks[left-2][0]);
				curr.add(terms.get(left-2));
			}
			if (want.equals("true")) curr.add("true");
			else curr.add("false");
			if (right<=n-2){
				curr.add(terms.get(right));
				curr.add(endworks[right+2][1]);
			}
			//pw.println(curr);
			//pw.println(want);
			String works = evaluate(curr).toLowerCase();
			if (works.equals(want)) pw.print("Y");
			else pw.print("N");
		}
		pw.close();
	}
	static String evaluate(List<String> curr){
		int jj = curr.size();
		while(curr.contains("and")){
			int c = curr.indexOf("and");
			curr.remove(c);
			if (curr.get(c-1).equals("true")&&curr.get(c).equals("true")){
				curr.set(c-1, "true");
			}
			else if (curr.get(c-1).equals("TRUE")){
				curr.set(c-1, "true");
			}
			else if (curr.get(c).equals("TRUE")){
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
				return "TRUE";
			}
			else if (curr.get(c-1).equals("TRUE")||curr.get(c).equals("TRUE")){
				return "TRUE";
			}
			else{
				curr.set(c-1, "false");
			}
			curr.remove(c);
		}
		return curr.get(0);
	}
}
