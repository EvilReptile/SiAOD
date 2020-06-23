package cham;

import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/1278/B
 */
public class App {
    public static void main( String[] args ) {
        Scanner scn = new Scanner(System.in);
        int score = scn.nextInt();

        for(int i = 0; i < score; i++)
            System.out.println(calculate(scn.nextInt(), scn.nextInt()));
    }

    private static String calculate(int first, int second){
        int d = Math.abs(first - second);
        int result = 1;

        if(d == 0)
            return "0";

        while(!ok(result, d))
            result++;

        return ""+result;
    }

    private static boolean ok(int result, int d){
        int sum = result * (result + 1) / 2;

        if(sum < d)
            return false;

        return sum % 2 == d % 2;
    }
}
