package pl.sda;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Rectangle2Test {

    @Test
    public void findAllCrossingPoints_SimpleCase(){

        // given
        Point point1 = new Point(2, 2);
        Point point2 = new Point(5, 5);
        Point point1a = new Point(3, 3);
        Point point2a = new Point(6, 6);
        Rectangle2 rectangle2 = new Rectangle2(point1, point2);
        Rectangle2 rectangle2a = new Rectangle2(point1a, point2a);

        //when
        List<Point> allCrossingPoints = rectangle2.findAllCrossingPoints(rectangle2a);

        //then
        assertEquals(allCrossingPoints.size(), 2);
        assertTrue(allCrossingPoints.contains(new Point(3, 5)));
        assertTrue(allCrossingPoints.contains(new Point(5, 3)));

    }

    @Test
    public void findAllCrossingPoints_HardCase(){

        // given
        Point point1 = new Point(2, 2);
        Point point2 = new Point(5, 5);
        Point point1a = new Point(2, 2);
        Point point2a = new Point(5, 5);
        Rectangle2 rectangle2 = new Rectangle2(point1, point2);
        Rectangle2 rectangle2a = new Rectangle2(point1a, point2a);

        //when
        List<Point> allCrossingPoints = rectangle2.findAllCrossingPoints(rectangle2a);

        //then
        assertEquals(4, allCrossingPoints.size());
        assertTrue(allCrossingPoints.contains(new Point(2, 2)));
        assertTrue(allCrossingPoints.contains(new Point(5, 5)));
        assertTrue(allCrossingPoints.contains(new Point(5, 2)));
        assertTrue(allCrossingPoints.contains(new Point(2, 5)));

    }

    @Test
    public void findAllCrossingPoints_InvertedCase(){

        // given
        Point point1 = new Point(2, 5);
        Point point2 = new Point(5, 2);
        Point point1a = new Point(5, 5);
        Point point2a = new Point(2, 2);
        Rectangle2 rectangle2 = new Rectangle2(point1, point2);
        Rectangle2 rectangle2a = new Rectangle2(point1a, point2a);

        //when
        List<Point> allCrossingPoints = rectangle2.findAllCrossingPoints(rectangle2a);

        //then
        assertEquals(4, allCrossingPoints.size());
        assertTrue(allCrossingPoints.contains(new Point(2, 2)));
        assertTrue(allCrossingPoints.contains(new Point(5, 5)));
        assertTrue(allCrossingPoints.contains(new Point(5, 2)));
        assertTrue(allCrossingPoints.contains(new Point(2, 5)));

    }
}

