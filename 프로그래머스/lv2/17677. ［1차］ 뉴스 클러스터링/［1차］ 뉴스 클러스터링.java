import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 자카드 유사도 : 집합 간의 유사도를 검사
        // J(A, B) -> 교집합의 크기 / 합집합의 크기
        // A, B 모두 공집합 -> J(A, B) = 1
        // 문자열은 두 글자씩 끊어서 다중집합으로
        
        if(str1.equals(str2)) return 65536;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            String str = str1.substring(i, i+2).replaceAll("[^a-z]", "");
            if(str.length() != 2) continue;
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            String str = str2.substring(i, i+2).replaceAll("[^a-z]", "");
            if(str.length() != 2) continue;
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        
        int union = 0;
        int intersect = 0;
        
        for(String key : map1.keySet()) {
            if(map2.keySet().contains(key)) {
                intersect += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else union += map1.get(key);
        }
        
        for(String key : map2.keySet()) {
            if(!map1.keySet().contains(key)) {
                union += map2.get(key);
            }
        }
        
        if(union==0) return 65536;
        answer = (int)((double)intersect/union*65536);
        
        return answer;
    }
}