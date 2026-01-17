// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class CorrectPlacement {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            Rectangle[] rects = new Rectangle[n];
            for (int i = 0; i<n; i++){
                int a = s.nextInt();
                int b = s.nextInt();
                rects[i] = new Rectangle(Math.min(a, b), Math.max(a, b), i);
            }

            Arrays.sort(rects, Comparator.comparingInt((Rectangle r)->r.x).thenComparingInt(r->r.y));
            int[] prev = new int[n];
            Arrays.fill(prev, -1);

            int compH = 1000000000;
            int compId = 0;
            int lowH = 1000000000;
            int lowId = 0;
            for (int i = 0; i<n; i++){
                if (i>0 && rects[i].x != rects[i-1].x && compH<lowH){
                    lowH = compH;
                    lowId = compId;
                }

                if (lowH<rects[i].y) prev[rects[i].id] = lowId;
                if (rects[i].y<compH){
                    compH = rects[i].y;
                    compId = rects[i].id+1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<n; i++) sb.append(prev[i]).append(" ");
            pw.println(sb);
        }
		pw.close();
	}
    static class Rectangle{
        public int x;
        public int y;
        public int id;

        public Rectangle(int a, int b, int i){
            x = a;
            y = b;
            id = i;
        }

        public boolean biggerThan(Rectangle e){
            return ((x>e.x && y>e.y));
        }

        public String toString(){
            return "("+x+", "+y+"): "+id;
        }
    }
}
