package qa.kurs.sandbox;

import static java.lang.Math.sqrt;

public class Point {

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int x;
  public int y;

  public double distance(Point p2) {
    return sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y)*(p2.y - this.y));
  }
}
