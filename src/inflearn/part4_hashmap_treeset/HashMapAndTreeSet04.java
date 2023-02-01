package inflearn.part4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMapAndTreeSet04 {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        int len = str2.length() - 1;

        for(int i=0; i<len; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }

        int lt = 0;

        for(int rt=len; rt<str1.length(); rt++) {
            map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);
            if(map1.equals(map2)) answer++;
            map1.put(str1.charAt(lt), map1.get(str1.charAt(lt)) - 1);
            if(map1.get(str1.charAt(lt)) == 0) map1.remove(str1.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMapAndTreeSet04 T = new HashMapAndTreeSet04();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();
        System.out.println(T.solution(str1, str2));
    }
}
