import java.io.*;
import java.util.*;

public class PoweredAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

            int[] max = new int[n];
            max[0] = nums[0];
            for (int i = 1; i<n; i++){
                max[i] = Math.max(nums[i], max[i-1]);
            }

            int[] diff = new int[n];
            int maxDiff = Integer.MIN_VALUE;
            for (int i = 0; i<n; i++){
                diff[i] = max[i]-nums[i];
                maxDiff = Math.max(maxDiff, diff[i]);
            }

            if (maxDiff==0) pw.println(0);
            else pw.println(Integer.toBinaryString(maxDiff).length());
        }
        pw.close();
    }
}
