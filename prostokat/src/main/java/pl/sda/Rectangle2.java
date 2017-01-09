package pl.sda;

import java.util.ArrayList;
import java.util.List;

//Rozwiazanie wstepne
//Niezbyt elegancko ale dziala dla wiekszosci przypadkow

public class Rectangle2 {

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;


    public Rectangle2(Point point1, Point point2) {

        if (point1.getY() < point2.getY()) {
            this.point1 = point1;
            this.point2 = point2;
        } else {
            this.point1 = point2;
            this.point2 = point1;
        }

        point3 = new Point(this.point1.getX(), this.point2.getY());
        point4 = new Point(this.point2.getX(), this.point1.getY());
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public List<Point> findAllCrossingPoints(Rectangle2 rectangle) {
        List<Point> crossingList = new ArrayList<Point>();

        crossingList.addAll(findVerticallyCrossingPoints(rectangle));
        for (int i = 0; i < rectangle.findVerticallyCrossingPoints(this).size(); i++) {
            if (!crossingList.contains(rectangle.findVerticallyCrossingPoints(this).get(i))) {
                crossingList.add(rectangle.findVerticallyCrossingPoints(this).get(i));
            }
        }

        return crossingList;
    }

    private List<Point> findVerticallyCrossingPoints(Rectangle2 rectangle) {
        //vertical (point1, point3)  (point4, point2)
        //horizon (point1, point4)  (point3, point2)

        List<Point> crossingList = new ArrayList<Point>();

        if (point1.getX() >= rectangle.getPoint3().getX() && point1.getX() <= rectangle.getPoint2().getX() &&
                rectangle.getPoint3().getY() >= point1.getY() && rectangle.getPoint3().getY() <= point3.getY()) {

            crossingList.add(new Point(point1.getX(), rectangle.getPoint3().getY()));
        }

        if (point2.getX() >= rectangle.getPoint3().getX() && point2.getX() <= rectangle.getPoint2().getX() &&
                rectangle.getPoint3().getY() >= point4.getY() && rectangle.getPoint3().getY() <= point2.getY()) {

            crossingList.add(new Point(point2.getX(), rectangle.getPoint3().getY()));
        }

        if (point1.getX() >= rectangle.getPoint1().getX() && point1.getX() <= rectangle.getPoint4().getX() &&
                rectangle.getPoint1().getY() >= point1.getY() && rectangle.getPoint1().getY() <= point3.getY()) {

            crossingList.add(new Point(point1.getX(), rectangle.getPoint1().getY()));
        }

        if ((point2.getX() >= rectangle.getPoint1().getX() && point2.getX() <= rectangle.getPoint4().getX() &&
                rectangle.getPoint1().getY() >= point4.getY() && rectangle.getPoint1().getY() <= point2.getY())) {

            crossingList.add(new Point(point2.getX(), rectangle.getPoint1().getY()));
        }

        return crossingList;
    }

//    public int calculateSquare(List<Point> crossingPoints) {
//        if (crossingPoints.size() == 4) {
//
//            return ;
//        } else if (crossingPoints.size() == 2) {
//
//            return ;
//        } else if (crossingPoints.size() == 1) {
//
//            return ;
//        } else {
//            throw new IllegalArgumentException();
//        }
//    }
}
