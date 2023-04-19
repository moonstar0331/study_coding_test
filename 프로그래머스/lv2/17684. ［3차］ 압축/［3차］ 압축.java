import java.util.*;
class Solution {
    public int[] solution(String msg) {
    
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++) {
            map.put(Character.toString('A'+i), i+1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int idx = 27;
        for(int i=0; i<msg.length(); i++) {
            String tmp = "";
            while(i<msg.length() && map.containsKey(tmp+msg.charAt(i))) {
                tmp += msg.charAt(i++);
            }
            
            list.add(map.get(tmp));
            
            if(i < msg.length()) {
                map.put(tmp+msg.charAt(i), idx++);
                i--;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}