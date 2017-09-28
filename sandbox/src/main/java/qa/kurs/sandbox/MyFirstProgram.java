package qa.kurs.sandbox;
import static java.lang.Math.*;

public class MyFirstProgram {

  public static void main(String[] args) {



    Point r = new Point(4,6, 5 , 8);

    System.out.println("Distance between points x(" + r.x1 + ","+ r.x2+ ") " +
            "and y(" + r.y1 + "," + r.y2 +") is " + distance(r));
  }




  public static double distance(Point r) {
    return sqrt((r.x2 - r.x1)^2+(r.y2-r.y1)^2);
  }
}