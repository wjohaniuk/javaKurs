package qa.kurs.sandbox;

import static java.lang.Math.sqrt;

public class Point {

  public int x1;
  public int y1;
  public int x2;
  public int y2;

  public Point(int x1, int x2, int y1, int y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;

  }

  public Point2(int x2,int y2){

  }

  public double distance() {
    return sqrt((this.x2 - this.x1)^2+(this.y2-this.y1)^2);
  }
}
