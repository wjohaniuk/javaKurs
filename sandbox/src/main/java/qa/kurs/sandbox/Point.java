package qa.kurs.sandbox;

import static java.lang.Math.sqrt;

public class Point {

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int x;
  public int y;

  public double distance(Point p1, Point p2) {
    return sqrt((p2.x - p1.x) ^ 2 + (p2.y - p1.y) ^ 2);
  }
}
