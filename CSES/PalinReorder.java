// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class PalinReorder {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int len = str.length();
		List<Character> chars = new ArrayList<>();
		int[] charCounts = new int[26];
		for (char x : str.toCharArray()){
			if (!chars.contains(x)) chars.add(x);
			charCounts[chars.indexOf(x)]++;
		}

		StringBuilder mid = new StringBuilder();
		StringBuilder ret = new StringBuilder();
		if (len%2==1){
			boolean found = false;
			for (int i = 0; i<charCounts.length && !found; i++){
				if (charCounts[i]%2==1) {
					mid.append(chars.get(i));
					charCounts[i]--;
					found = true;
				}
			}
		}

		boolean works = true;
		for (int c : charCounts) if (c%2==1) works = false;
		if (works){
			for (int i = 0; i<charCounts.length; i++){
				while (charCounts[i]>0){
					charCounts[i]-=2;
					ret.append(chars.get(i));
				}
			}
			StringBuilder rev = new StringBuilder(ret.toString());
			rev.reverse();
			ret.append(mid.toString());
			ret.append(rev);
			System.out.println(ret.toString());
		}
		else {
			System.out.println("NO SOLUTION");
		}


		//System.out.println(chars);
		//System.out.println(Arrays.toString(charCounts));
	}
}
