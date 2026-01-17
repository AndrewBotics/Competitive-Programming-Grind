// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class milkexchange {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		int t = s.nextInt();
		String text = s.next();
		List<Character> dirs = new ArrayList<>();
		List<Integer> cows = new ArrayList<>();
		for (int i = 0; i<n; i++) dirs.add(text.charAt(i));
		for (int i = 0; i<n; i++) cows.add(s.nextInt());
		if (dirs.get(0)=='L'){
			for (int i = 0; i<n && dirs.get(0)=='L'; i++){
				dirs.remove(0);
				dirs.add('L');
				cows.add(cows.get(0));
				cows.remove(0);
			}
		}
		else if (dirs.get(dirs.size()-1)=='R'){
			Collections.reverse(dirs);
			Collections.reverse(cows);
			for (int i = 0; i<n && dirs.get(0)=='R'; i++){
				dirs.remove(0);
				dirs.add('R');
				cows.add(cows.get(0));
				cows.remove(0);
			}
			Collections.reverse(dirs);
			Collections.reverse(cows);
		}

		long lost = 0;
		long currR = 0;
		long currL = 0;
		for (int i = 0; i<n; i++){
			int ind = -1;
			int ind2 = -1;
			boolean rsearching = true;
			boolean lsearching = true;
			for (int j = i; j<n && rsearching; j++){
				if (dirs.get(j)=='R'){
					currR += cows.get(j);
					ind = j;
				}
				else {
					rsearching = false;
				}
			}
			for (int j = ind+1; j<n && lsearching; j++){
				if (dirs.get(j)=='L'){
					currL += cows.get(j);
					ind2 = j;
				}
				else {
					lsearching = false;
				}
			}
			if (!(ind==-1 || ind2==-1)){
				currR -= cows.get(ind);
				currL -= cows.get(ind+1);
				lost += Math.min(t, currR);
				lost += Math.min(t, currL);
				currR = 0;
				currL = 0;
			}
			i = ind2;
		}

		long sum = 0;
		for (int i : cows) sum += i;
		pw.println(sum-lost);
		pw.close();
	}
}