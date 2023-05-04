class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        int max = Math.max(n, m);
        for(int i=1; i<=max; i++) {
            if(number%n==0 && number%m==0) {
                answer = 1;
                return answer;
            }
        }
        return answer;
    }
}