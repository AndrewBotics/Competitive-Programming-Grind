import java.io.*;
import java.util.*;

public class socialdistancing1 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("socdist1.in"));
		PrintWriter pw = new PrintWriter(new File("socdist1.out"));
		int n = s.nextInt();
		String cows = s.next();
		List<Integer> groups = new ArrayList<>();
		int curr = 0;
		boolean search = true;
		for (int i = 0; i<n && search; i++){
			char c = cows.charAt(i);
			if (c=='1'){
				if (curr==0){
					if (i!=0) {
						search = false;
					}
				}
				else {
					groups.add(curr);
					curr = 0;
				}
				groups.add(-1);
			}
			else {
				curr++;
			}
		}
		if (curr!=0) groups.add(curr);
		if (groups.size()==1) pw.println(groups.get(0)-1);
		else if (search) pw.println(Math.max(type1(groups), type2(groups)));
		else pw.println(1);
		pw.close();
	}
	static int type1(List<Integer> cows){
		int n = cows.size();
		List<Integer> rets = new ArrayList<>();
		for (int i = 0; i<n; i++){
			if (cows.get(i)!=-1){
				if (i==0 || i==n-1) rets.add(cows.get(i));
				else rets.add((cows.get(i) + (cows.get(i)%2))/2);
			}
		}
		Collections.sort(rets);
		if (rets.size()<2) return 1;
		return rets.get(rets.size()-2);
	}
	static int type2(List<Integer> cows){
		int n = cows.size();
		List<Integer> rets = new ArrayList<>();
		for (int i = 0; i<n; i++){
			if (cows.get(i)>1){
				if (i==0 || i==n-1) rets.add((cows.get(i)-cows.get(i)%2)/2);
				else {
					if (cows.get(i)%3==2) rets.add((cows.get(i)+1)/3);
					else if (cows.get(i)%3==1) rets.add(cows.get(i-1)/3);
					else rets.add(cows.get(i)/3);
				}
			}
		}
		Collections.sort(rets);
		if (rets.size()==0) return 1;
		return rets.get(rets.size()-1);
	}
}