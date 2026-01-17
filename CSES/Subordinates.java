// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Subordinates {
    static List<Integer>[] employees;
    static int ct;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());
        StringTokenizer st = new StringTokenizer(r.readLine());
        
        employees = new ArrayList[n+1];
        for (int i = 1; i<=n; i++) employees[i] = new ArrayList<>();
        for (int i = 2; i<=n; i++){
            employees[Integer.parseInt(st.nextToken())].add(i);
        }
        //System.out.println(Arrays.toString(employees));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=n; i++){
            traverse(i);
            sb.append(ct-1).append(" ");
            ct = 0;
        }
        pw.println(sb.toString());
        pw.close();
    }
    public static void traverse(int i){
        ct++;
        for (int num : employees[i]) traverse(num);
    }
}

