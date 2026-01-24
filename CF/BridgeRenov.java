import java.io.*;
import java.util.*;

public class BridgeRenov {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        pw.println(solve(n));


		pw.close();
	}
    public static int solve(int n){
        int ct = 0;
        ct += n/2;
        int left18 = n;
        int left21 = n;
        if (n%2==1){
            left21--;
            ct++;
        }
        if (left21%2==1){
            left21--;
            left18-=2;
            ct++;
        }
        ct += left21/2;
        left18 -= left21/2;
        ct += (left18+2)/3;
        return ct;
    }
}
