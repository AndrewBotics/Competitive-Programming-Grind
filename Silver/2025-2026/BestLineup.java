// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class BestLineup {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            Integer[] nums = new Integer[n];
            for (int i = 0; i<n; i++) nums[i] = s.nextInt();
            List<ArrayList<Integer>> best = new ArrayList<>();
            for (int i = 0; i<n; i++){
                while (best.size()>0 && best.get(best.size()-1).get(0)<nums[i]) best.remove(best.size()-1);
                best.add(new ArrayList<>(List.of(nums[i], i)));
            }
            best.add(0, new ArrayList<>(List.of(n+1, -1)));
            best.add(new ArrayList<>(List.of(-1, n)));

            int mi = -1;
            int ni = -1;
            int mc = -1;
            boolean going = true;
            for (int i = 1; i<best.size()-1 && going; i++){
                if (best.get(i).get(1)!=best.get(i-1).get(1)+1){
                    int left = (i==0)?0:best.get(i-1).get(1)+1;
                    int right = best.get(i).get(1)-1;
                    if (max(nums, left, right)>=best.get(i+1).get(0)){
                        mi = best.get(i).get(1);
                        ni = left;
                        mc = best.get(i).get(0);
                        going = false;
                    }
                }
            }

            List<Integer> ret = new ArrayList<>(Arrays.asList(nums));
            if (mi!=-1) {
                ret.remove(mi);
                ret.add(ni, mc);
            }
            List<Integer> newBest = new ArrayList<>();
            for (int i = 0; i<n; i++){
                while (!newBest.isEmpty() && newBest.get(newBest.size()-1)<ret.get(i)) newBest.remove(newBest.size()-1);
                newBest.add(ret.get(i));
            }
            StringBuilder sb = new StringBuilder();
            for (int i : newBest) sb.append(i).append(" ");
            sb.deleteCharAt(sb.length()-1);
            pw.println(sb);
        }
		pw.close();
	}
    public static int max(Integer[] nums, int left, int right){
        int max = 0;
        for (int i = left; i<=right; i++) max = Math.max(nums[i], max);
        return max;
    }
}
