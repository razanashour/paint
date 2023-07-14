/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Color;//s
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Dell
 */
public class Circle  extends abs  {

       private int width;
       private int height;
       
     
    public Circle(int width, int height, Point position) {
        super(position);
        this.width = width;
        this.height=height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    



    @Override
    public void draw(Graphics canvas) {
     canvas .setColor(getFillColor());
      canvas.fillOval((int) (getPosition().x),(int) (getPosition().y) ,width, height);
    canvas.setColor(getColor());
  
    canvas.drawOval((int) (getPosition().x), (int) (getPosition().y),width, height);

    }

   
        @Override
    public boolean contains(Point p) {
    Point position =getPosition();
//   Ellipse2D.Double c= new Ellipse2D.Double();
//   c.setFrame(position.x, position.y, 2*radius, 2*radius);
java.awt.Rectangle r = new java.awt.Rectangle();
        r.setLocation(position);
        r.setSize(width, height);
        return r.contains(p);
    }

    @Override
    public void moveTo(Point p) {
        int x = getDraggingPoint().x;
        int y = getDraggingPoint().y;
        int xdifference = p.x - x;
        int ydifference = p.y - y;
        setPosition(new Point(getPosition().x + xdifference, getPosition().y+ ydifference));

    }   

    @Override
    public Shape clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resize(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
