// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class LisaMartians {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            Container[] nums = new Container[n];
            for (int i = 0; i<n; i++){
                nums[i] = new Container(s.nextInt(), i+1);
            }

            Arrays.sort(nums);

            int mins = Integer.MAX_VALUE;
            int curr = 0;
            for (int i = 0; i<n-1; i++){
                if ((nums[i].v ^ nums[i+1].v)<mins){
                    mins = (nums[i].v ^ nums[i+1].v);
                    curr = i;
                }
            }
            int ans = (nums[curr].v ^ ((1<<k)-1));
            pw.println(nums[curr].ind+" "+nums[curr+1].ind+" "+ans);
            //pw.println(((nums[curr].v^ans)&(nums[curr].v^ans)));
            //pw.println();
        }

		pw.close();
	}

    static class Container implements Comparable<Container> {
        int v;
        int ind;
        
        public Container(int value, int index){
            v = value;
            ind = index;
        }

        @Override
        public int compareTo(Container c){
            return v-c.v;
        }
    }
}
