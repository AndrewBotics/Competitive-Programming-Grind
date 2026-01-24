import java.io.*;
import java.util.*;

public class OlympiadTrip {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int l = s.nextInt();
            int r = s.nextInt();
            String xor = Integer.toBinaryString(l^r);
            int a = l|((1<<(xor.length()-1))-1);
            int b = a+1;
            int c = (a==l?r:l);
            pw.println(a+" "+b+" "+c);
            //pw.println(l+" "+r+"\n");
        }
		pw.close();
	}
}
