import java.io.*;
import java.util.*;

public class loadbalancing {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("balancing.in"));
        PrintWriter pw = new PrintWriter("balancing.out");
        int n = s.nextInt();
        List<Integer>[] coords = new ArrayList[2];
        coords[0] = new ArrayList<>();
        coords[1] = new ArrayList<>();
        for (int i = 0; i<n; i++){
            coords[0].add(s.nextInt());
            coords[1].add(s.nextInt());
        }
        List<Integer>[] sortx = new ArrayList[2];
        List<Integer>[] sorty = new ArrayList[2];

        sortx[0] = clone(coords[0]);
        sortx[1] = clone(coords[1]);
        sorty[0] = new ArrayList<>();
        sorty[1] = clone(coords[1]);
        Collections.sort(sorty[1]);
        for (int i = 0; i<n; i++){
            int ind = sortx[1].indexOf(sorty[1].get(i));
            sorty[0].add(sortx[0].get(ind));
            sortx[0].remove(ind);
            sortx[1].remove(ind);
        }

        sortx[0] = clone(coords[0]);
        sortx[1] = new ArrayList<>();
        Collections.sort(sortx[0]);
        for (int i = 0; i<n; i++){
            int ind = coords[0].indexOf(sortx[0].get(i));
            sortx[1].add(coords[1].get(ind));
            coords[0].remove(ind);
            coords[1].remove(ind);
        }

        coords[0] = new ArrayList<>();
        coords[1] = new ArrayList<>();
        coords[0].add(sortx[0].get(0)-1);
        coords[1].add(sorty[1].get(0)-1);
        for (int i = 0; i<n-1; i++){
            if (!(sortx[0].get(i)==sortx[0].get(i+1) || sortx[0].get(i)==sortx[0].get(i+1)+1)) coords[0].add(sortx[0].get(i+1)+1);
            if (!(sorty[1].get(i)==sorty[1].get(i+1) || sorty[1].get(i)==sorty[1].get(i+1)+1)) coords[1].add(sorty[1].get(i+1)+1);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i : coords[0]){
            for (int j : coords[1]){
                int temp = calc(sortx, i, j);
                if (min > temp) min = temp;
            }
        }
        pw.println(min);
        pw.close();
    }
    static int calc(List<Integer>[] coords, int x, int y){
        int quad1 = 0;
        int quad2 = 0;
        int quad3 = 0;
        int quad4 = 0;
        //Organized according to the Cartesian Plane.
        for (int h = 0; h<coords[0].size(); h++){
            int i = coords[0].get(h);
            int j = coords[1].get(h);
            if (i>x && j>y) quad1++;
            else if (i<x && j>y) quad2++;
            else if (i<x && j<y) quad3++;
            else if (i>x && j<y) quad4++;
        }
        return Math.max(Math.max(quad1, quad2), Math.max(quad3, quad4));
    }
    static List<Integer> clone(List<Integer> coord){
        List<Integer> ret = new ArrayList<>();
        for (int x : coord) ret.add(x);
        return ret;
    }
}

