package inflearn.part8_DFS_BFS2;

import java.util.ArrayList;
import java.util.Scanner;

class Point3 {
    int x, y;
    Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BfsAndDfs15 {

    static int n, m, len, answer=Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point3> pz, hs;

    public void DFS(int L, int s) {
        if(L==m) {
            int sum=0;
            for(Point3 h : hs) {
                int dis = Integer.MAX_VALUE;
                for(int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x-pz.get(i).x) + Math.abs(h.y-pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i=s; i<len; i++) {
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        BfsAndDfs15 T = new BfsAndDfs15();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int tmp = kb.nextInt();
                if(tmp==1) hs.add(new Point3(i, j));
                else if(tmp==2) pz.add(new Point3(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
