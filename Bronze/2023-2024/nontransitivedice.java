import java.io.*;
import java.util.*;

public class nontransitivedice {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = s.nextInt();
        for (int i = 0; i<n; i++){
            int[] x = {s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()};
            int[] y = {s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()};
            String going = "no";
            for (int a = 1; a<11; a++){
                for (int b = 1; b<11; b++){
                    for (int c = 1; c<11; c++){
                        for (int d = 1; d<11; d++){
                            if (going.equals("no")){
                                int[] z = {a, b, c, d};
                                if (checkmore(x, y) && checkmore(y, z) && checkmore(z, x)){
                                    going = "yes";
                                }
                                else if (checkmore(y, x) && checkmore(z, y) && checkmore(x, z)){
                                    going = "yes";
                                }
                            }
                        }
                    }
                }
            }
            pw.println(going);
        }
        pw.close();
    }
    static boolean checkmore(int[] first, int[] second){
        float num = 0;
        float dupes = 0;
        for (int i : first){
            for (int j: second){
                if (i>j) num++;
                else if (i==j) dupes++;
            }
        }
        return num > (16 - dupes)/2;
    }
}

