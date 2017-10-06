package qa.kurs.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testArea(){
    Point p1 = new Point(2, 4);
    Point p2 = new Point(4, 4);
    Assert.assertEquals( p1.distance(p2), 2.0);
  }
}
