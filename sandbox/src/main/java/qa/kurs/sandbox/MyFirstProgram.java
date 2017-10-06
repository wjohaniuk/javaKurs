package qa.kurs.sandbox;


import static java.lang.Math.sqrt;

public class MyFirstProgram {

  public static void main(String[] args) {


    Point p1 = new Point(2, 5);
    Point p2 = new Point(6, 6);

    System.out.println("Distance between points x(" + p1.x + "," + p2.x + ") " +
            "and y(" + p1.y + "," + p2.y + ") is " + p1.distance(p2));
  }


}