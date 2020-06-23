package cham;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/455/A
 */
public class App {

    static HashMap<String, Integer> seq = new HashMap<>();

    public static void main( String[] args ) {
        Scanner scn = new Scanner(System.in);
        scn.nextLine();
        String max = "0";
        for(String num : scn.nextLine().split(" ")){
            if(max.hashCode() < num.hashCode())
                max = num;

            if(seq.get(num) != null)
                seq.put(num, seq.get(num) + 1);
            else
                seq.put(num, 1);
        }

        System.out.println(calculate(Integer.parseInt(max)));
    }

    public static int calculate(int size){
        if(size <= 0)
            return 0;

        else if(size == 1)
            if(seq.get("1") != null)
                return seq.get("1");
            else
                return 0;

        int num;
        if(seq.get(""+size) == null)
            num = 0;
        else
            num = seq.get(""+size) * size;

        return Math.max(calculate(size - 1), calculate(size - 2) + num);
    }

}
