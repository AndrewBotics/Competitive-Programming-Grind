import java.io.*;
import java.util.*;

public class majorityopinion {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n>0){
			int t = s.nextInt();
			List<Integer> ret = new ArrayList<>();
			int x = -1;
			int y = 0;
			int z = s.nextInt();
			for (int i = 0; i<t-1; i++){
				if (y==z && !ret.contains(z)) ret.add(z);
				if (x==z && !ret.contains(z)) ret.add(z);
				x = y;
				y = z;
				z = s.nextInt();
			}
			if (y==z && !ret.contains(z)) ret.add(z);
			if (x==z && !ret.contains(z)) ret.add(z);
			Collections.sort(ret);
			if (ret.size()==0){
				System.out.print(-1);
			}
			else {
				for (int i = 0; i<ret.size()-1; i++){
					System.out.print(ret.get(i)+" ");
				}
				System.out.print(ret.get(ret.size()-1));
			}
			if (n!=1) System.out.print("\n");
			n--;
		}
	}
}