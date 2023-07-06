import java.util.*;
class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] check;
    
    public int solution(String numbers) {
        int answer = 0;
        
        arr = new char[numbers.length()];
        check = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        
        dfs("", 0);
        
        answer = set.size();
        
        return answer;
    }
    
    static void dfs(String str, int cnt) {
        int num;
        
        if(!str.equals("")) {
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        
        if(cnt == arr.length) return;
        
        for(int i=0; i<arr.length; i++) {
            if(check[i]) continue;
            check[i] = true;
            dfs(str+arr[i], cnt+1);
            check[i] = false;
        }
    }
    
    static boolean isPrime(int num) {
        if(num==0 || num==1) return false;
        for(int i=2; i*i<=num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}