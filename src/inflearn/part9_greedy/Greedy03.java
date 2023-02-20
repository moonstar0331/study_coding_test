package inflearn.part9_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time1 implements Comparable<Time1> {
    public int time;
    public char state;

    Time1(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time1 ob) {
        if(this.time==ob.time) return this.state - ob.state;
        else return this.time - ob.time;
    }
}

class Greedy03 {

    public int solution(ArrayList<Time1> arr) {
        int answer = Integer.MIN_VALUE;

        Collections.sort(arr);
        int cnt = 0;
        for(Time1 ob : arr) {
            if(ob.state=='s') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }


    public static void main(String[] args) {
        Greedy03 T = new Greedy03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time1> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            arr.add(new Time1(sT, 's'));
            arr.add(new Time1(eT, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}
