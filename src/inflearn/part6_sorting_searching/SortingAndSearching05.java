package inflearn.part6_sorting_searching;

import java.util.Scanner;

class SortingAndSearching05 {
    public String solution(int n, int[] arr) {

        for(int i=0; i<arr.length; i++) {
            int x = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                if(x == arr[j]) return "D";
            }
        }

        return "U";
    }

    public static void main(String[] args) {
        SortingAndSearching05 T = new SortingAndSearching05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
