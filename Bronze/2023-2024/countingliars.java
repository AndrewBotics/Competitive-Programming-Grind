import java.io.*;
import java.util.*;

public class countingliars {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = s.nextInt();
		List<Integer> lesses = new ArrayList<>();
		List<Integer> greaters = new ArrayList<>();
        List<Integer> choices = new ArrayList<>();
		for (int i = 0; i<n; i++){
			String t = s.next();
			int num = s.nextInt();
			if (t.equals("G")){
				greaters.add(num);
			}
			else {
				lesses.add(num);
			}
            choices.add(num);
		}
		int ret = Integer.MAX_VALUE;
		for (int i : choices){
			int temp = 0;
			for (int g : greaters) if (i<g) temp++;
			for (int l : lesses) if (i>l) temp++;
			ret = Math.min(ret, temp);
		}

		pw.println(ret);
		pw.close();
	}
}
