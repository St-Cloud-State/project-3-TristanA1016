import java.awt.Graphics;
import java.awt.*;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void drawLabel(String s, Point p) {
    if (p != null) {
      if (s != null) {
        graphics.drawString(s, (int) p.getX(), (int) p.getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(s);
    graphics.drawString("_", (int)p.getX() + length, (int)p.getY());
  }

  @Override
  public void drawTriangle(Point point1, Point point2, Point point3) {
    if (point1 != null && point2 != null && point3 != null) {
      // Convert points to integers for drawing
      int x1 = Math.round((float) (point1.getX()));
      int y1 = Math.round((float) (point1.getY()));
      int x2 = Math.round((float) (point2.getX()));
      int y2 = Math.round((float) (point2.getY()));
      int x3 = Math.round((float) (point3.getX()));
      int y3 = Math.round((float) (point3.getY()));

      // Draw the three sides of the triangle
      graphics.drawLine(x1, y1, x2, y2); // Side between point1 and point2
      graphics.drawLine(x2, y2, x3, y3); // Side between point2 and point3
      graphics.drawLine(x3, y3, x1, y1); // Side between point3 and point1
    }
  }

  public void drawLine(Point point1,  Point point2) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (point1 != null) {
      i1 = Math.round((float) (point1.getX()));
      i2 = Math.round((float) (point1.getY()));
      if (point2 != null) {
        i3 = Math.round((float) (point2.getX()));
        i4 = Math.round((float) (point2.getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
 
}
