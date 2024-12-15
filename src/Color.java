import java.util.*;
import java.lang.*;
import java.io.*;

class Point {
    public int red;
    public int green;
    public int blue;

    public Point(int red, int green, int blue) {

        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public boolean euclideanDistance(Point b) {

        double distance = Math.sqrt(Math.pow((b.red - this.red), 2) + Math.pow((b.green - this.green), 2) + Math.pow((b.blue - this.blue), 2));

//        System.out.println("Distance: " + distance);
        if (distance >= 128 || distance == 0) {
            return true;
        }

        return false;


    }


}

public class Color {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Point> points = new ArrayList<Point>();

        int testcase = in.nextInt();
//        System.out.println(testcase);

        for (int i = 0; i < testcase; i++) {

            boolean colorsDistance = true;

            int numOfColors = in.nextInt();

            for (int j = 0; j < numOfColors; j++) {

                int red = in.nextInt();
                int green = in.nextInt();
                int blue = in.nextInt();

                Point p = new Point(red, green, blue);

                points.add(p);

            }

            for (int k = 0; k < points.size(); k++) {

                for (int j = 1; j < points.size(); j++) {


                    boolean comparison = points.get(k).euclideanDistance(points.get(j));
//                    System.out.println(points.get(k).red);
//                    System.out.println(points.get(j).red);

                    if (comparison == false) {
                        colorsDistance = false;
                        break;
                    }

                }

                if (colorsDistance == false) {
                    break;
                }

            }

            if (colorsDistance == true) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }

        }

    }

}
