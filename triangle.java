/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Dell
 */
public class triangle  extends abs{
    
    private Point p2;
    private Point p3;

    public triangle( Point position,Point p2, Point p3) {
        super(position);
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }
    
        @Override
    public void draw(Graphics g) {
          int xP[] = new int[]{getPosition().x, p2.x, p3.x};
          int yP[] = new int[]{getPosition().y, p2.y, p3.y};
         g.setColor(getFillColor());
         g.fillPolygon(xP, yP, 3);
         g.setColor(this.getColor());
         g.drawPolygon(xP, yP, 3);
      
         
         int x1=getPosition().x;
         int y1=getPosition().y; 
          int x2=p2.x;
          int y2=p2.y;
          int x3=p3.x;
          int y3=p3.y;
          
          if(isSelected())
          {
              g.setColor(Color.BLACK);
              g.fillRect(x1-5, y1-5, 10, 10);
              g.fillRect(x2-5, y2-5, 10, 10); 
              g.fillRect(x3-5, y3-5, 10, 10);
          }
  
  
    }// arraylist takes three points of the triangle
     @Override
    public boolean contains(Point p) {
        int xP[] = new int[]{getPosition().x,p2.x, p3.x};
        int yP[] = new int[]{getPosition().y, p2.y, p3.y};

        Polygon po = new Polygon(xP, yP, 3);

        return po.contains(p);
    }
     @Override
    public void moveTo(Point p) {
        int xdifference = p.x - getDraggingPoint().x;
        int ydifference = p.y - getDraggingPoint().y;
        p2 = new Point(p2.x + xdifference, p2.y + ydifference);
        p3= new Point(p3.x + xdifference, p3.y + ydifference);
        setPosition(new Point(getPosition().x + xdifference, getPosition().y + ydifference));

    }
        @Override
    public Shape clone() throws CloneNotSupportedException {
    Shape cloned= new triangle(this.getPosition(),this.getP2(),this.getP3());
    cloned.setPosition(getPosition());
    cloned.setColor(getColor());
    cloned.setFillColor(getFillColor());
    return cloned;
    
    }
    public boolean firstpt(Point p)
    {
        int x=getPosition().x;
        int y=getPosition().y;
        java.awt.Rectangle r=new java.awt.Rectangle(x-5,y-5,10,10);
        return r.contains(p.getX(),p.getY());
    }
    
     public boolean secondpt(Point p)
    {
        int x=p2.x;
        int y=p2.y;
        java.awt.Rectangle r=new java.awt.Rectangle(x-5,y-5,10,10);
        return r.contains(p.getX(),p.getY());
    }
    
      public boolean thirdpt(Point p)
    {
        int x=p3.x;
        int y=p3.y;
        java.awt.Rectangle r=new java.awt.Rectangle(x-5,y-5,10,10);
        return r.contains(p.getX(),p.getY());
    }

    @Override
    public void resize(Point p) {
     if(firstpt(getDraggingPoint())){
         setPosition(p);
    }
     if(secondpt(getDraggingPoint())){
        p2= p;
    }
     
     if(thirdpt(getDraggingPoint())){
        p3= p;
    }  
      
}
}
