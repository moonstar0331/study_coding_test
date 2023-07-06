import java.util.*;

class Solution {
    
    static String[] arr;
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        
        rec_func(word, 0, "");
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    static void rec_func(String word, int depth, String str) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            rec_func(word, depth+1, str+arr[i]);
        }
    }
}