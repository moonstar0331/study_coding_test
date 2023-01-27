package inflearn.part1_string;

import java.util.Scanner;

class String09 {

    public String solution(String str) {
        String answer = "";
        String tmp = str.toLowerCase().replaceAll("[^0-9]", "");
        answer = String.valueOf(Integer.parseInt(tmp));

        return answer;
    }

    public static void main(String[] args) {
        String09 T = new String09();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
