// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class stampgrid {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int ct = s.nextInt();
        while (ct>0){
            int n = s.nextInt();
            char[][] ngrid = new char[n][n];
            for (int i = 0; i<n; i++) ngrid[i] = s.next().toCharArray();
            int k = s.nextInt();
            char[][] kgrid = new char[k][k];
            for (int i = 0; i<k; i++) kgrid[i] = s.next().toCharArray();
            for (int i = 0; i<n-k+1; i++){
                for (int j = 0; j<n-k+1; j++){
                    ngrid = stamp(ngrid, kgrid, i, j);
                    for (int r = 0; r<3; r++){
                        kgrid = rotate(kgrid);
                        ngrid = stamp(ngrid, kgrid, i, j);
                    }
                }
            }
            String ret = "YES";
            for (int i = 0; i<n && ret=="YES"; i++){
                for (int j = 0; j<n; j++){
                    if (ngrid[i][j]=='*') ret = "NO";
                }
            }
            pw.println(ret);
            ct--;
        }
        pw.close();
    }
    static char[][] stamp(char[][] ngrid, char[][] kgrid, int i, int j){
        int n = ngrid.length;
        int k = kgrid.length;
        char[][] shift = new char[n][n];
        for (int a = 0; a<n; a++){
            for (int b = 0; b<n; b++){
                shift[a][b] = ngrid[a][b];
            }
        }
        for (int a = 0; a<k; a++){
            for (int b = 0; b<k; b++){
                if (kgrid[a][b]=='*'){
                    if (shift[a+i][b+j]=='*') shift[a+i][b+j] = '-';
                    else if (shift[a+i][b+j]=='.') return ngrid;
                }
            }
        }
        return shift;
    }
    static char[][] rotate(char[][] kgrid){
        int k = kgrid.length;
        char[][] shift = new char[k][k];
        for (int i = 0; i<k; i++){
            for (int j = 0; j<k; j++){
                shift[i][j] = kgrid[k-j-1][i];
            }
        }
        return shift;
    }
}

