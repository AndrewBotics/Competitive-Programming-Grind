// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class walkingalongafence {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        int p = s.nextInt();
        List<String> pos = new ArrayList<>();
        int a = s.nextInt();
        int b = s.nextInt();
        int at = a;
        int bt = b;
        int c = 0;
        int d = 0;
        for (int i = 1; i<=p; i++){
            if (i!=p){
                c = s.nextInt();
                d = s.nextInt();
            }
            else {
                c = a;
                d = b;
            }
            if (at!=c){
                if (at<c){
                    for (int j = at; j<c; j++){
                        pos.add(j+" "+d);
                    }
                }
                else {
                    for (int j = at; j>c; j--){
                        pos.add(j+" "+d);
                    }
                }
            }
            else {
                if (bt<d){
                    for (int j = bt; j<d; j++){
                        pos.add(c+" "+j);
                    }
                }
                else {
                    for (int j = bt; j>d; j--){
                        pos.add(c+" "+j);
                    }
                }
            }
            at = c;
            bt = d;
        }
        //pw.println(pos);
        for (int cas = 0; cas<n; cas++){
            int ind1 = pos.indexOf(s.nextInt()+" "+s.nextInt());
            int ind2 = pos.indexOf(s.nextInt()+" "+s.nextInt());
            pw.println(Math.min(Math.abs(ind2-ind1), Math.min(ind1, ind2)+pos.size()-Math.max(ind1, ind2)));
        }
        pw.close();
    }
}

