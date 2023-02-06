package inflearn.part6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

class SortingAndSearching05_2 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) return "D";
        }

        return answer;
    }

    public static void main(String[] args) {
        SortingAndSearching05_2 T = new SortingAndSearching05_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
