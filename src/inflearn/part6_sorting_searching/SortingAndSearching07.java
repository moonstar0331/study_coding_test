package inflearn.part6_sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y-o.y;
        else return this.x - o.x;
    }
}

class SortingAndSearching07 {

    public static void main(String[] args) {
        SortingAndSearching07 T = new SortingAndSearching07();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);

        for(Point o : arr)
            System.out.println(o.x + " " + o.y);
    }
}
