package inflearn.part1_string;

import java.util.Scanner;

public class String07_2 {

    public String solution(String str) {
        String answer = "YES";
        int len = str.length();
        str = str.toLowerCase();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String07_2 T = new String07_2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
