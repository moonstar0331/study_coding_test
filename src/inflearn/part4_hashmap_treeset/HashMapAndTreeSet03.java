package inflearn.part4_hashmap_treeset;

import java.util.*;

class HashMapAndTreeSet03 {
    public List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt=0;
        for(int rt=k-1; rt<n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMapAndTreeSet03 T = new HashMapAndTreeSet03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        for(int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}
