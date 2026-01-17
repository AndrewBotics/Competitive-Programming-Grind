// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Villagers {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int n = s.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i<n; i++) nums.add(s.nextInt());

            Collections.sort(nums);

            long tot = 0;
            while (!nums.isEmpty()){
                tot += nums.removeLast();
                if (!nums.isEmpty()) nums.removeLast();
            }
            pw.println(tot);
        }

		pw.close();
	}
}
