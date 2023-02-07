package inflearn.part6_sorting_searching;

import java.util.Scanner;

class SortingAndSearching04 {
    public int[] solution(int s, int k, int[] arr) {
        int[] answer = new int[s];

        for(int x : arr) {
            int pos = -1;
            for(int i=0; i<s; i++) {
                if(x==answer[i]) pos=i;
            }
            if(pos==-1) {
                for(int i=s-1; i>=1; i--) {
                    answer[i] = answer[i-1];
                }
                answer[0]=x;
            } else {
                for(int i=pos; i>=1; i--) {
                    answer[i] = answer[i-1];
                }
                answer[0]=x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SortingAndSearching04 T = new SortingAndSearching04();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[k];
        for(int i=0; i<k; i++) {
            arr[i] = kb.nextInt();
        }

        for(int x : T.solution(s, k, arr)) {
            System.out.print(x + " ");
        }
    }
}
