// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class milkingorder {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("milkorder.in"));
		PrintWriter pw = new PrintWriter(new File("milkorder.out"));
		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		int[] cows = new int[m];
		int[] order = new int[n+1];
		for (int i = 0; i<m; i++) cows[i] = s.nextInt();
		order[0] = -1;
		for (int i = 0; i<k; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			order[b] = a;
		}
		List<Integer> q = new ArrayList<>();
		int last = 0;
		for (int i = 0; i<m; i++){
			int curr = cows[i];
			if (contains(order, curr)){
				for (int j = indexOf(order, curr)-1; j>=0 && q.size()>0; j--){
					if (order[j]==0) {
						order[j] = q.get(q.size()-1);
						q.remove(q.size()-1);
					}
				}
				last = indexOf(order, curr);
			}
			else q.add(curr);
		}
		if (q.contains(1)){
			for (int i = last; i<=n && q.size()>0; i++){
				if (order[i]==0){
					order[i] = q.get(0);
					q.remove(0);
				}
			}
		}
		else {
			for (int i = n; i>0 && q.size()>0; i--){
				if (order[i]==0){
					order[i] = q.get(q.size()-1);
					q.remove(q.size()-1);
				}
			}
		}

		int a = indexOf(order, 1);
		if (a==-1) a = indexOf(order, 0);
		pw.println(a);
		//pw.println(last);
		//pw.println(Arrays.toString(order));
		pw.close();
	}
	static boolean contains(int[] order, int curr){
		for (int i : order) if (i==curr) return true;
		return false;
	}
	static int indexOf(int[] order, int curr){
		for (int i = 0; i<order.length; i++) if (order[i]==curr) return i;
		return -1;
	}
}
