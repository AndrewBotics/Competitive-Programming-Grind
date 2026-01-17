// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Retaliation {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = s.nextInt();
        for (int tt = 0; tt<t; tt++){
            int n = s.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i<n; i++) nums[i] = s.nextInt();
            //pw.println(Arrays.toString(nums));

            boolean works = true;
            if (nums[0]==nums[n-1]){
                works = nums[0]%(1+n)==0;
                for (int i = 0; i<n && works; i++){
                    if (nums[i]!=nums[0]) works = false;
                }
            }
            else if (nums[0]<nums[n-1]){
                int diff = nums[1]-nums[0];
                for (int i = 1; i<n && works; i++){
                    if (nums[i]-nums[i-1]!=diff) works = false;
                }
                if (works) works = (nums[0]-diff)%(1+n)==0 && nums[0]-diff>=0;
            }
            else {
                int diff = nums[0]-nums[1];
                for (int i = 1; i<n && works; i++){
                    if (nums[i-1]-nums[i]!=diff) works = false;
                }
                if (works) works = (nums[n-1]-diff)%(1+n)==0 && nums[n-1]-diff>=0;
            }
            pw.println(works?"YES":"NO");
        }
        pw.close();
    }
}

