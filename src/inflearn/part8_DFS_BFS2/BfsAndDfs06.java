package inflearn.part8_DFS_BFS2;

import java.util.Scanner;

class BfsAndDfs06 {

    static int[] pm, ch, arr;
    static int n, m;

    public void DFS(int L) {
        if(L==m) {
            for(int x : pm) {
                System.out.print(x + " ");
                System.out.println();
            }
        } else {
            for(int i=0; i<n; i++) {
                if(ch[i]==0) {
                    ch[i]=1;
                    pm[L]=arr[i];
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }


    public static void main(String[] args) {
        BfsAndDfs06 T = new BfsAndDfs06();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        T.DFS(0);
    }
}
