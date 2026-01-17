import java.io.*;
import java.util.*;

public class feb {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		String febs = s.next();
		List<Integer> varies = new ArrayList<>();
		int curr = 0;
		for (int i = 0; i<n; i++){
			if (febs.charAt(i)=='B'){
				if (curr!=0){
					varies.add(curr);
					curr = 0;
				}
				varies.add(-1);
			}
			else if (febs.charAt(i)=='E'){
				if (curr!=0) {
					varies.add(curr);
					curr = 0;
				}
				varies.add(-2);
			}
			else {
				curr++;
			}
		}
		if (curr!=0) varies.add(curr);
		
		int size = varies.size();
		if (size==1 && varies.get(0)>0){
			pw.println(varies.get(0));
			for (int i = 0; i<varies.get(0); i++){
				pw.println(i);
			}
		}
		else{
			int minone = 0;
			int maxone = 0;
			int mintwo = 0;
			int maxtwo = 0;
			for (int i = 0; i<size; i++){
				if (i==0 || i==size-1){
					if (varies.get(i)>0) maxone+=varies.get(i);
				}
				else {
					int x = varies.get(i-1);
					int y = varies.get(i);
					int z = varies.get(i+1);
					if (y>0){
						if (x==z){
							if (y%2==1){
								maxtwo+=y+1;
							}
							else {
								mintwo+=1;
								maxtwo+=y+1;
							}
						}
						else{
							if (y%2==1){
								mintwo+=1;
								maxtwo+=y;
							}
							else {
								maxtwo+=y;
							}
						}
					}
				}
			}

			int base = 0;
			for (int i = 0; i<size-1; i++){
				if (varies.get(i)==varies.get(i+1)) base++;
			}

			List<Integer> rets = new ArrayList<>();
			for (int i = mintwo; i<=maxtwo; i+=2){
				for (int j = minone; j<=maxone; j++){
					if (!rets.contains(i+j+base)) rets.add(i+j+base);
				}
			}
			Collections.sort(rets);
			pw.println(rets.size());
			for (int i : rets){
				pw.println(i);
			}
			//pw.println(minone+" "+maxone+" "+mintwo+" "+maxtwo+" "+base);
		}
		//pw.println(varies);
		pw.close();
	}
}