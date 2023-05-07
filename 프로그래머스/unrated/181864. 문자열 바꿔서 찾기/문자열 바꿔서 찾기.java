class Solution {
    public int solution(String myString, String pat) {
        String tmp = "";
        for(char x : myString.toCharArray()){
            if(x == 'A') tmp += "B";
            else tmp += "A";
        }
        
        if(tmp.contains(pat)) return 1;
        return 0;
    }
}