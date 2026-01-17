// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class GravityFalls {
    public static int compareInd = 0;
    static class Row implements Comparable<Row>{
        public int[] nums;

        public Row(int[] init){
            nums = init;
        }

        @Override
        public int compareTo(Row r){
            return compare(nums, r.nums);
        }

        public String toString(){
            return Arrays.toString(nums);
        }
    }
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            List<Row> rows = new ArrayList<>();
            int maxInd = 0;
            for (int i = 0; i<n; i++){
                int a = s.nextInt();
                maxInd = Math.max(maxInd, a);
                int[] row = new int[a];
                for (int j = 0; j<a; j++) row[j] = s.nextInt();
                rows.add(new Row(row));
            }
            //pw.println(rows);
            StringBuilder ret = new StringBuilder();
            compareInd = 0;
            int x = 0;
            while (compareInd<maxInd){
                Collections.sort(rows);
                for (int i = compareInd; i<rows.get(0).nums.length; i++) ret.append(rows.get(0).nums[i]).append(" ");
                compareInd = rows.get(0).nums.length;
                for (int i = rows.size()-1; i>=0; i--) if (rows.get(i).nums.length<=compareInd) rows.remove(i);
                //pw.println(compareInd);
                //pw.println(rows);
            }
            pw.println(ret.toString());
        }
		pw.close();
	}
    public static int compare(int[] one, int[] two){
        if (compareInd>one.length) return -1;
        if (compareInd>two.length) return 1;
        int a = one.length;
        int b = two.length;
        for (int i = compareInd; i<Math.min(a, b); i++) if (one[i]!=two[i]) return one[i]-two[i];
        return a-b;
    }
}
