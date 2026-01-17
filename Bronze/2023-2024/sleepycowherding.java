import java.io.*;
import java.util.*;

public class sleepycowherding {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("herding.in"));
		PrintWriter pw = new PrintWriter(new File("herding.out"));
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		if(b-a==1&&c-a==2) pw.println(0);
		else if(b-a==2||c-b==2) pw.println(1);
		else pw.println(2);
		pw.println(Math.max(b-a-1, c-b-1));
		pw.close();
	}
}