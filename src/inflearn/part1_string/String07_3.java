package inflearn.part1_string;

import java.util.Scanner;

class String07_3 {

    public String solution(String str) {
        String answer = "NO";

        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        String07_3 T = new String07_3();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
