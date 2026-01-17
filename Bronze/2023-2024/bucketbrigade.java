// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class bucketbrigade {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("buckets.in"));
		PrintWriter pw = new PrintWriter(new File("buckets.out"));
		int[] b = new int[2];
		int[] r = new int[2];
		int[] l = new int[2];
		for (int i = 0; i<10; i++){
			char[] str = s.next().toCharArray();
			for (int j = 0; j<10; j++){
				if (str[j]=='B'){
					b[0] = i;
					b[1] = j;
				}
				else if (str[j]=='R'){
					r[0] = i;
					r[1] = j;
				}
				else if (str[j]=='L'){
					l[0] = i;
					l[1] = j;
				}
			}
		}
		if (b[0]==l[0]){
			int d = Math.abs(b[1]-l[1])-1;
			if (r[0]==b[0] && ((l[1]<r[1] && r[1]<b[1]) || (b[1]<r[1] && r[1]<l[1]))) pw.println(d+2);
			else pw.println(d);
		}
		else if (b[1]==l[1]){
			int d = Math.abs(b[0]-l[0])-1;
			if (r[1]==b[1] && ((l[0]<r[0] && r[0]<b[0]) || (b[0]<r[0] && r[0]<l[0]))) pw.println(d+2);
			else pw.println(d);
		}
		else {
			pw.println(Math.abs(b[0]-l[0])+Math.abs(b[1]-l[1])-1);
		}
		pw.close();
	}
}
