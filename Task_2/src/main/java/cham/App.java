package cham;

import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/550/A
 */
public class App {
    public static void main( String[] args ) {
        Scanner scn  = new Scanner(System.in);
        String line = scn.nextLine();

        int abIndex = line.indexOf("AB");
        if(abIndex != -1){
            String firstLine = line.substring(0, abIndex);
            String secondLine = line.substring(abIndex + 2);
            if(firstLine.indexOf("BA") != -1 || secondLine.indexOf("BA") != -1){
                System.out.println("YES");
                return;
            }
        }

        abIndex = line.indexOf("BA");
        if(abIndex != -1){
            String firstLine = line.substring(0, abIndex);
            String secondLine = line.substring(abIndex + 2);
            if(firstLine.indexOf("AB") != -1 || secondLine.indexOf("AB") != -1){
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    }
}
