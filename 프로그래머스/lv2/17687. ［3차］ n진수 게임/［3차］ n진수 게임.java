class Solution {
    public String solution(int n, int t, int m, int p) {
        // n: 진법
        // t: 미리 구할 숫자의 갯수
        // m: 게임에 참가하는 인원
        // p: 튜브의 순서
        String answer = "";
        
        // 0부터 순차적으로 n진수로 변환한다.
        // 인원별로 한자리씩 말한다.
        // 튜브의 순서가 되면 해당 숫자를 answer에 추가하고 넘어간다.
        int num = 0; // 현재 게임에서 진행하는 수
        int seq = 0; // 현재 대답을 해야하는 사람의 순서
        
        int total = 1;
        while(total <= t) {
            String bi = Integer.toString(num, n);
            
            for(int i=0; i<bi.length(); i++) {
                if(seq == p-1) {
                    answer += bi.charAt(i);
                    total++;
                }
                if(total > t) break;
                seq = (seq+1) % m;
            }
            num++;
        }
        
        return answer.toUpperCase();
    }
}