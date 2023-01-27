package inflearn.part1_string;

import java.util.Scanner;

public class String09_2 {

    // answer = answer * 10 + (X - 48)
    public int solution(String str) {
        int answer = 0;
        for(char x : str.toCharArray()) {
            if (x>=48 && x<=57) answer = answer * 10 + (x - 48);
        }

        return answer;
    }

    public static void main(String[] args) {
        String09_2 T = new String09_2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
