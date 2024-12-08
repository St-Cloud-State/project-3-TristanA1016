import java.awt.*;
import java.io.Serializable;

public class Triangle extends Item implements Serializable {
    private Point point1;
    private Point point2;
    private Point point3;


    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        this.point1 = vertex1;
        this.point2 = vertex2;
        this.point3 = vertex3;
    }


    public Triangle(Point vertex1, Point vertex2) {
        this(vertex1, vertex2, null);
    }


    public Triangle(Point vertex1) {
        this(vertex1, null, null);
    }

    // Default constructor
    public Triangle() {
        this(null, null, null);
    }



    // Render the triangle by drawing lines between its vertices
    @Override
    public void render(UIContext uiContext) {
        uiContext.drawTriangle(point1, point2, point3);
    }

    // Optional: Determine if a point is inside the triangle
    @Override
    public boolean includes(Point point) {
        return (distance(point, point1) < 10.0) ||
                (distance(point, point2) < 10.0) ||
                (distance(point, point3) < 10.0);
    }

    public void translate(int dx, int dy) {
        if (point1 != null) {
            point1.translate(dx, dy);
        }
        if (point2 != null) {
            point2.translate(dx, dy);
        }
        if (point3 != null) {
            point3.translate(dx, dy);
        }
    }

    public void setPoint1(Point point) {
        this.point1 = point;
    }

    public void setPoint2(Point point) {
        this.point2 = point;
    }

    public void setPoint3(Point point) {
        this.point3 = point;
    }

    public Point getPoint1() {
        return this.point1;
    }

    public Point getPoint2() {
        return this.point2;
    }

    public Point getPoint3() {
        return this.point3;
    }

    public String toString() {
        return "Triangle: p1=" + point1 + " p2=" + point2 + " p3=" + point3;
    }
}