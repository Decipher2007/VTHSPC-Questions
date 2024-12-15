import java.util.*;
import java.lang.*;
import java.io.*;

public class pythonComment {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean started = false;

        ArrayList<String> list = new ArrayList<String>();


        int testcase = in.nextInt();

        Scanner in2 = new Scanner(System.in);

        for (int i = 0; i < testcase; i++) {

            String text = in2.nextLine();
            list.add(text);

        }

        System.out.println(list);
        int count = 0;

        int maxinumCount = 0;

        for (int i = 0; i < list.size(); i++) {

            StringBuilder str = new StringBuilder(list.get(i).replaceAll("\\s", ""));

            if (list.get(i).charAt(0) == '#') {

                int index = str.lastIndexOf("#");
                int occurrences = index + 1;

                maxinumCount = Math.max(maxinumCount, occurrences);

                started = true;

            }

            if (started && list.get(i).indexOf("#") >= 0) {

                int index = str.lastIndexOf("#");
                int occurrences = index + 1;

                maxinumCount = Math.max(maxinumCount, occurrences);


            } else if (started && list.get(i).indexOf("#") == -1) {

                count += maxinumCount;

                started = false;
                maxinumCount = 0;


            }

        }

        count += maxinumCount;

        System.out.println(count);



    }

}
