import java.io.*;
import java.util.*;

public class moooperations {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		for (int t = 0; t<n; t++){
			char[] curr = s.next().toCharArray();
			int c = curr.length;
			if (c>=3){
				int type = -1;
				for (int i = 0; i<c-2 && type!=0; i++){
					if (curr[i+1]=='O') {
						int temp = 0;
						if (curr[i]=='O') temp++;
						if (curr[i+2]=='M') temp++;
						if (type!=-1) type = Math.min(temp, type);
						else type = temp;
					}
				}
				if (type!=-1) pw.println(c-3+type);
				else pw.println(-1);
			}
			else pw.println(-1);
		}
		pw.close();
	}
}