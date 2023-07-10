import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각
        // 롤케이크를 공평하게 자르는 방법의 수를 return    
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        }
        
        Map<Integer, Integer> tmp = new HashMap<>();
        for(int i=0; i<topping.length; i++) {
            tmp.put(topping[i], tmp.getOrDefault(topping[i], 0)+1);
            
            map.put(topping[i], map.getOrDefault(topping[i], 0)-1);
            if(map.get(topping[i]) <= 0) {
                map.remove(topping[i]);
            }
            
            if(map.keySet().size() == tmp.keySet().size()) answer++;
        }
        
        return answer;
    }
}