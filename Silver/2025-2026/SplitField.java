// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class SplitField {
    static class Point implements Comparable<Point>{
        public long x;
        public long y;
        public static boolean vertical;

        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p){
            if (vertical) return (int) (y-p.y);
            return (int) (x-p.x);
        }

        public String toString(){
            return "{"+x+"/"+y+"}";
        }
    }
	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(System.in);
        //PrintWriter pw = new PrintWriter(System.out);
        Scanner s = new Scanner(new File("split.in"));
        PrintWriter pw = new PrintWriter("split.out");
        int n = s.nextInt();
        Point[] pts = new Point[n];

        long minX = Integer.MAX_VALUE;
        long minY = Integer.MAX_VALUE;
        long maxX = 0;
        long maxY = 0;
        for (int i = 0; i<n; i++){
            pts[i] = new Point(s.nextLong(), s.nextLong());
            maxX = Math.max(maxX, pts[i].x);
            minX = Math.min(minX, pts[i].x);
            maxY = Math.max(maxY, pts[i].y);
            minY = Math.min(minY, pts[i].y);
        }
        //pw.println(minX+" "+maxX+" "+minY+" "+maxY);

        long area = (maxX-minX)*(maxY-minY);
        long minArea = area;
        for (int bool = 0; bool<2; bool++){
            Point.vertical = !Point.vertical;
            Arrays.sort(pts);
            //pw.println(Arrays.toString(pts));
            for (int i = 1; i<n; i++){
                long minX1 = Integer.MAX_VALUE;
                long minY1 = Integer.MAX_VALUE;
                long maxX1 = 0;
                long maxY1 = 0;
                for (int j = 0; j<i; j++){
                    maxX1 = Math.max(maxX1, pts[j].x);
                    minX1 = Math.min(minX1, pts[j].x);
                    maxY1 = Math.max(maxY1, pts[j].y);
                    minY1 = Math.min(minY1, pts[j].y);
                }

                long minX2 = Long.MAX_VALUE;
                long minY2 = Long.MAX_VALUE;
                long maxX2 = 0;
                long maxY2 = 0;
                for (int j = i; j<n; j++){
                    maxX2 = Math.max(maxX2, pts[j].x);
                    minX2 = Math.min(minX2, pts[j].x);
                    maxY2 = Math.max(maxY2, pts[j].y);
                    minY2 = Math.min(minY2, pts[j].y);
                }
                //pw.println(maxX1+" "+minX1+" "+maxY1+" "+minY1);
                //pw.println(maxX2+" "+minX2+" "+maxY2+" "+minY2);
                minArea = Math.min(minArea, (maxX1-minX1)*(maxY1-minY1)+(maxX2-minX2)*(maxY2-minY2));
                //pw.println(minArea);
            }
        }

        pw.println(area-minArea);
		pw.close();
	}
}
