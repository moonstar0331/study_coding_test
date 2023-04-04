package programmers.Lv2;

// Lv2 . JadenCase 문자열 만들기
public class JadenCaseString {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split("");

        String last = "";
        for(int i=0; i<arr.length; i++) {
            if(last.equals("") || last.equals(" ")) {
                answer += arr[i].toUpperCase();
            } else {
                answer += arr[i].toLowerCase();
            }
            last = arr[i];
        }

        return answer;
    }
}
