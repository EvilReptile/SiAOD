package cham;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * https://codeforces.com/problemset/problem/1288/C
 */
public class App {
    public static void main( String[] args ) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        System.out.println(factorial(n + m*2 - 1).divide(factorial(2*m)).divide(factorial(n - 1)).mod(BigInteger.valueOf((long) (Math.pow(10, 9) + 7))));
    }

    private static BigInteger factorial(int i){
        if(i == 1 || i == 0)
            return BigInteger.valueOf(1);
        else{
            return BigInteger.valueOf(i).multiply(factorial(i - 1));
        }
    }
}
