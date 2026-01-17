import java.io.*;
import java.util.*;

public class familytree {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("family.in"));
        PrintWriter pw = new PrintWriter(new File("family.out"));
        int n = s.nextInt();
        String cowX = s.next();
        String cowY = s.next();
        String[][] relations = new String[n][2];
        s.nextLine();
        for (int i = 0; i < n; i++) relations[i] = s.nextLine().split(" ");
        int minXDist = 0;
        int minYDist = 0;
        String commonAncestor = cowX;
        while (commonAncestor != null) {
            if (getAncestorDistance(commonAncestor, cowY, relations) != -1) {
                minYDist = getAncestorDistance(commonAncestor, cowY, relations);
                break;
            }
            commonAncestor = getMother(commonAncestor, relations);
            minXDist++;
        }
        if (commonAncestor == null) pw.println("NOT RELATED");
        else if (minXDist > 1 && minYDist > 1) pw.println("COUSINS");
        else if (minXDist == 1 && minYDist == 1) pw.println("SIBLINGS");
        else if (minXDist == 0 || minYDist == 0) {
            boolean xIsAncestor = minXDist == 0;
            pw.print(commonAncestor + " is the ");
            for (int i = 0; i < (xIsAncestor ? minYDist : minXDist) - 2; i++) pw.print("great-");
            if ((xIsAncestor ? minYDist : minXDist) > 1) pw.print("grand-");
            pw.println("mother of " + (xIsAncestor ? cowY : cowX));
        }
        else {
            boolean auntIsX = minXDist == 1;
            pw.print((auntIsX ? cowX : cowY) + " is the ");
            for (int i = 0; i < (auntIsX ? minYDist : minXDist) - 2; i++) pw.print("great-");
            pw.println("aunt of " + (auntIsX ? cowY : cowX));
        }
        pw.close();
    }

    private static String getMother(String child, String[][] relations) {
        for (String[] pair : relations) if (child.equals(pair[1])) return pair[0];
        return null;
    }

    private static int getAncestorDistance(String start, String end, String[][] relations) {
        int dist = 0;
        while (end != null) {
            if (end.equals(start)) return dist;
            dist++;
            end = getMother(end, relations);
        }
        return -1;
    }
}
