/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *
 * @author Dell
 */
public class Line  extends abs {
    

    private Point endPoint;


    public Line(Point endPoint, Point position) {
        super(position);
        this.endPoint = endPoint;
    }


    
    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    
    
    
    @Override
    public void draw(Graphics canvas) {
       canvas .setColor(getFillColor());
     canvas.setColor(getColor());
     canvas.drawLine((int) getPosition().getX(), (int) getPosition().getY(), (int) endPoint.getX(), (int) endPoint.getY());// leh etnen?
     
       int x1=getPosition().x;
       int y1=getPosition().y; 
       int x2=endPoint.x;
       int y2=endPoint.y;
          
          if(isSelected())
          {
              canvas.setColor(Color.BLACK);
              canvas.fillRect(x1-5, y1-5, 10, 10);
              canvas.fillRect(x2-5, y2-5, 10, 10); 
            
          }
  
    }

     @Override
    public boolean contains(Point p) {
 
        int x1, y1, x2, y2;
        x1 = getPosition().x;
        y1 = getPosition().y;
        x2 = endPoint.x;
        y2 = endPoint.y;
        Line2D.Float x = new Line2D.Float(x1, y1, x2, y2);
        double distance = x.ptSegDist(p);
        if (distance < 2) {
            return true;
        } else {
            return false;
        }
    }
    
    

    @Override
    public void moveTo(Point p) {
        int xdifference = p.x - getPosition().x;
        int ydifference = p.y - getPosition().y;
        endPoint = new Point(endPoint.x + xdifference, endPoint.y + ydifference);
        //setPosition( new Point(getPosition().x + xdifference, getPosition().y+ ydifference));
        setPosition(p);
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
    Shape cloned= new Line(this.endPoint,this.getPosition());
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
        int x=endPoint.x;
        int y=endPoint.y;
        java.awt.Rectangle r=new java.awt.Rectangle(x-5,y-5,10,10);
        return r.contains(p.getX(),p.getY());
    }   

    @Override
    public void resize(Point p) {
  if(firstpt(getDraggingPoint())){
         setPosition(p);
    }
     if(secondpt(getDraggingPoint())){
      setEndPoint(p);
    }
     
    }
    
}
    
    
    
    
    
    

