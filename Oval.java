/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Dell
 */
public class Oval  extends abs  {

       private int width;
       private int height;
       
     
    public Oval(int width, int height, Point position) {
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
     canvas.setColor(getColor());
        int x = getPosition().x;
        int y = getPosition().y;
       // canvas.drawRect(x, y, width, height);
        canvas.drawOval(x, y, width, height);
    if (isSelected()) {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(x - 5, y - 5, 10, 10);
            canvas.fillRect(x + width - 5, y - 5, 10, 10);
            canvas.fillRect(x - 5, y + height - 5, 10, 10);
            canvas.fillRect(x + width - 5, y + height - 5, 10, 10);
        }

    }

   
        @Override
    public boolean contains(Point p) {
    Point position =getPosition();
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
    Shape cloned= new Oval(this.getWidth(),this.getHeight(),this.getPosition());
    cloned.setPosition(getPosition());
    cloned.setColor(getColor());
    cloned.setFillColor(getFillColor());
    return cloned;
    
    }
    
//    public JsonObject getAsJson(){
//         obj.put("shapetype", "oval");
//                obj.put("x", this.getPosition().x);
//                obj.put("y", r.getPosition().y);
//                obj.put("width", r.getWidth());
//                obj.put("height", r.getHeight());
//                obj.put("rgb", r.getColor().getRGB());
//                obj.put("rgb2", r.getFillColor().getRGB());
//    }

    @Override
    public void resize(Point p) {
     int x1 = getDraggingPoint().x;
        int y1 = getDraggingPoint().y;
        int x2 = p.x;
        int y2 = p.y;
        if (ULCorners(getDraggingPoint())) {
            width = width + x1 - x2;
            height = height + y1 - y2;
            getPosition().x = getPosition().x + x2 - x1;
            getPosition().y = getPosition().y + y2 - y1;
        } else if (URCorners(getDraggingPoint())) {
            width = width + x2 - x1;
            height = height + y1 - y2;
            getPosition().y = getPosition().y + y2 - y1;
        } else if (LLCorners(getDraggingPoint())) {
            width = width + x1 - x2;
            height = height + y2 - y1;
            getPosition().x = x2;
        } else if (LRCorners(getDraggingPoint())) {
            width = width - x1 + x2;
            height = height + y2 - y1;
        }
        if (width < 0) {
            width = -1 * width;
            getPosition().x -= width;
        }
        if (height < 0) {
            height = -1 * height;
            getPosition().y -= height;
        }
    
    }
     public boolean URCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean LRCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x + width - 5, y + height - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean LLCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y + height - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }

    public boolean ULCorners(Point p) {
        int x = getPosition().x;
        int y = getPosition().y;
        java.awt.Rectangle r = new java.awt.Rectangle(x - 5, y - 5, 10, 10);
        return r.contains(p.getX(), p.getY());
    }
}
