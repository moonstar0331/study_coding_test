package inflearn.part4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMapAndTreeSet01 {
    public char solution(int n, String str) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();

        for(char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMapAndTreeSet01 T = new HashMapAndTreeSet01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }
}
