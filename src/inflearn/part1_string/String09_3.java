package inflearn.part1_string;

import java.util.Scanner;

public class String09_3 {
    public int solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) {
                answer += x;
            }
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        String09_3 T = new String09_3();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
