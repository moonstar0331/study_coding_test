package inflearn.part4_hashmap_treeset;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

class HashMapAndTreeSet05 {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for(int i=0 ;i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int l=j+1; l<n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt=0;
        for (int x : tSet) {
            cnt++;
            if(cnt==k) return x;
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMapAndTreeSet05 T = new HashMapAndTreeSet05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
