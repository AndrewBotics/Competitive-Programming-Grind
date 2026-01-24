// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class LittleGirlSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int[] elems = new int[n+2];
        for (int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            elems[Integer.parseInt(st.nextToken())]++;
            elems[Integer.parseInt(st.nextToken())+1]--;
        }
        for (int i = 1; i<=n; i++){
            elems[i] += elems[i-1];
        }

        Arrays.sort(elems);
        //pw.println(Arrays.toString(elems));

        long ret = 0;
        for (int i = 1; i<=n; i++){
            ret += (long)nums[nums.length-i]*elems[elems.length-i];
        }
        pw.println(ret);

        pw.close();
    }
}
