package inflearn.part4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMapAndTreeSet02 {
    public String solution(String str1, String str2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for(char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(char x : str2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            else map.put(x, map.get(x)-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMapAndTreeSet02 T = new HashMapAndTreeSet02();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();

        System.out.println(T.solution(str1, str2));
    }
}
