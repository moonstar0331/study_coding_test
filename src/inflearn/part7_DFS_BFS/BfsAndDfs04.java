package inflearn.part7_DFS_BFS;

import java.util.Scanner;

class BfsAndDfs04 {
    static int[] fibo;
    public int solution(int n) {
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else {
            return fibo[n] = solution(n-2) + solution(n-1);
        }
    }

    public static void main(String[] args) {
        BfsAndDfs04 T = new BfsAndDfs04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1];
        T.solution(n);
        for(int i=1; i<=n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
