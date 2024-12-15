import java.util.*;
import java.lang.*;
import java.io.*;

public class hokie {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int values = in.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();



        for (int i = 0; i < values; i++) {

            int x = in.nextInt();
            list.add(x);


        }

        int[] prefix = new int[list.size()];

        prefix[0] = list.get(0);

//        System.out.println(prefix[0]);

        for (int i = 1; i < list.size(); i++) {

            prefix[i] = prefix[i-1] + list.get(i);
//            System.out.println(prefix[i] + " ");

        }

        int ways = 0;

        for (int i = 0; i < list.size() - 1; i++) {

            if (prefix[i] == (prefix[list.size() - 1] - prefix[i])) {
//                System.out.println(prefix[i]);
//                System.out.println((prefix[list.size() - 1] - prefix[i]));

                ways++;
            }

        }

        System.out.println(ways);

    }




}
