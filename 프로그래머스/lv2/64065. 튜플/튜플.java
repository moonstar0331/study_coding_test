import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String[] str = s.substring(2, s.length()-2).split("},\\{");
        List<String> list = new ArrayList<>();
        
        Arrays.sort(str, (a, b) -> a.length() - b.length());
        for(int i=0; i<str.length; i++) {
            for(String x : str[i].split(",")) {
                if(!list.contains(x)) list.add(x);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}