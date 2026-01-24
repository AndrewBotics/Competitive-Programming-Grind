import java.util.*;
import java.io.*;

public class Wu {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        String[] xors = new String[m];
        for (int i = 0; i<m; i++) xors[i] = br.readLine();

        for (int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int ct = 0;
            String a = st.nextToken();
            String b = st.nextToken();
            for (String j : xors) if (execute(j, a, nums)<=Integer.parseInt(b)) ct++;
            pw.println(ct);
        }

        pw.close();
    }
    public static int execute(String x, String y, int[] nums){
        int total = 0;
        for (int i = 0; i<nums.length; i++){
            if (x.charAt(i)==y.charAt(i)) total += nums[i];
        }
        return total;
    }
}
