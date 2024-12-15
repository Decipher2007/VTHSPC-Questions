import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Communication {

    public static boolean[] dfs_num;
    public static ArrayList<ArrayList<ArrayList<Integer>>> al;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int humanBases = in.nextInt();
        int communications = in.nextInt();
        int components = in.nextInt();

        dfs_num = new boolean[humanBases];

        al = new ArrayList<ArrayList<ArrayList<Integer>>>();

        for (int i = 0; i < humanBases; i++) {
            ArrayList<ArrayList<Integer>> empty = new ArrayList<ArrayList<Integer>>();
            al.add(empty);
        }

//        System.out.println(al);

        ArrayList<Integer> findThreshold = new ArrayList<>();

        for (int i = 0; i < communications; i++) {
            ArrayList<Integer> pairList = new ArrayList<Integer>();

            int base = in.nextInt();
            base--;
            int connection = in.nextInt();
            connection--;
            int weight = in.nextInt();

            pairList.add(connection);
            pairList.add(weight);

            ArrayList<Integer> oppositepairList = new ArrayList<Integer>();
            oppositepairList.add(base);
            oppositepairList.add(weight);

            al.get(i).add(pairList);
            al.get(base).add(oppositepairList);
            findThreshold.add(weight);
        }

        Collections.sort(findThreshold);

//        System.out.println(al);

        int numCC = 0;
        String answer = "Impossible";
        boolean thresholdFound = false;
        for (int i = findThreshold.get(0); i <= findThreshold.get(findThreshold.size() - 1); i++) {

            for (int u = 0; u < humanBases; u++) {
                if (dfs_num[u] == false) {
                    numCC++;
                    dfs(u, i);
                }
            }

            dfs_num = new boolean[humanBases];

//            System.out.println(numCC);

            if (numCC == components) {
                thresholdFound = true;
                System.out.println(i);
                break;
            }

//            System.out.println("Index: " + i);

            numCC = 0;
            if (thresholdFound) {
                break;
            }


        }

        if (thresholdFound == false) {
            System.out.println(answer);
        }



    }

    static void dfs(int u, int threshold) {
        dfs_num[u] = true;

        for (ArrayList<Integer> vertex: al.get(u)) {

//            System.out.println(vertex.get(0));
//              System.out.println("Next Vertex: " + vertex.get(1));
//              System.out.println("Threshold: " + threshold);

            if (dfs_num[vertex.get(0)] == false && vertex.get(1) >= threshold) {
                dfs(vertex.get(0), threshold);
            }

        }



    }


}
