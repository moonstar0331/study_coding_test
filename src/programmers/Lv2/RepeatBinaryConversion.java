package programmers.Lv2;

// Lv2. 이진 변환 반복하기
public class RepeatBinaryConversion {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int zero = 0;

        while(!s.equals("1")) {
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') zero++;
            }
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = zero;

        return answer;
    }
}
