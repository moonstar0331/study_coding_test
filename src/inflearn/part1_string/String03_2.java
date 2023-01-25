package inflearn.part1_string;

import java.util.Scanner;

public class String03_2 {

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        while((pos=str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len>m) {
                m=len;
                answer=tmp;
            }
            str=str.substring(pos+1);
        }

        if (str.length() > m) answer = str;

        return answer;
    }

    public static void main(String[] args) {
        String03_2 T = new String03_2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
