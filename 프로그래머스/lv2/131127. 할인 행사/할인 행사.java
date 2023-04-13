import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for(int j=0; j<10; j++) {
                tmp.put(discount[i+j], tmp.getOrDefault(discount[i+j], 0)+1);
            }
            
            boolean flag = true;
            for(String key : map.keySet()) {
                if(map.get(key) > tmp.getOrDefault(key, 0)) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}