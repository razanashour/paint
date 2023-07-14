/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dell
 */
    abstract class abs implements Shape,Moveable{

       private Color fillcolor;
       private Point position;
       private Color color;
       private Point draggingPoint;
       private boolean selected;
       
        public abs(Point position) {
        this.position = position;
    }
        

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
       @Override
    public void setPosition(Point position) {
        this.position=position;
    }

       @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

       @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }
    

   
       @Override
    public Point getPosition() {
        return position;
    }

       @Override
    public void setColor(Color color) {
       this.color=color;
    }

 
       @Override
    public Color getColor() {
    return color;
    }

 
       @Override
    public void setFillColor(Color color) {
   fillcolor =color;
    }

       @Override
   public Color getFillColor() {
       return fillcolor;
   }
    
       @Override
    public abstract void draw(Graphics canvas);
    
    @Override
    public abstract Shape clone() throws CloneNotSupportedException;
    
      
}
