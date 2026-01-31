//note this fails TCs 10, 15, 20 for some reason; please feel free
//to reach out and let me know why

import java.io.*;
import java.util.*;

public class TestTubes {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int p = s.nextInt();
            String a = s.next();
            String b = s.next();
            List<String> ans = solve(n, a, b);
            pw.println(ans.size());
            if (p!=1) for (String str : ans) pw.println(str);
        }
		pw.close();
	}
    public static List<String> solve(int n, String a, String b){
        List<Integer> first = gen(a);
        List<Integer> second = gen(b);
        //System.out.println(first+" "+second);
        
        return accSolve(first, second);
    }
    public static List<Integer> gen(String a){
        List<Integer> list = new ArrayList<>();
        list.add(a.charAt(0)-'0');
        for (int i = 1; i<a.length(); i++){
            if (a.charAt(i)-'0'!=list.get(list.size()-1)) list.add(a.charAt(i)-'0');
        }
        return list;
    }
    public static List<String> accSolve(List<Integer> first, List<Integer> second){
        List<String> ret = new ArrayList<>();
        if (first.size()==1 && second.size()==1) return ret;


        if (first.get(first.size()-1)==second.get(second.size()-1)){
            if (first.size()>second.size()) {
                ret.add("1 2");
                first.remove(first.size()-1);
            }
            else if (second.size()>first.size()) {
                ret.add("2 1");
                second.remove(second.size()-1);
            }
        }
        if (first.size()==1 && second.size()==1) return ret;

        int three = 0;
        if (first.size()>1 && (first.get(first.size()-1)!=first.get(0) || first.get(first.size()-1)!=second.get(0))) {
            ret.add("1 3");
            three = first.remove(first.size()-1);
        }
        else if (second.size()>1 && (second.get(second.size()-1)!=first.get(0) || second.get(second.size()-1)!=second.get(0))) {
            ret.add("2 3");
            three = second.remove(second.size()-1);
        }
        //System.out.println(three+" "+first+" "+second);
        if (first.size()==1 && second.size()==1) return ret;

        if (first.get(0)!=three) {
            while (first.size()>1){
                int curr = first.remove(first.size()-1);
                if (curr==three) ret.add("1 3");
                else ret.add("1 2");
            }
            while (second.size()>1){
                int curr = second.remove(second.size()-1);
                if (curr==three) ret.add("2 3");
                else ret.add("2 1");
            }
            if (first.get(0)==second.get(0)) {
                ret.add("2 1");
                ret.add("3 2");
            }
            else if (three==first.get(0)) ret.add("3 1");
            else ret.add("3 2");
        }
        else {
            while (second.size()>1){
                int curr = second.remove(second.size()-1);
                if (curr==three) ret.add("2 3");
                else ret.add("2 1");
            }
            while (first.size()>1){
                int curr = first.remove(first.size()-1);
                if (curr==three) ret.add("1 3");
                else ret.add("1 2");
            }
            if (three==first.get(0)) ret.add("3 1");
            else ret.add("3 2");
        }
        return ret;
    }
}
