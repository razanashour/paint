/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package paint;

/**
 *
 * @author Dell
 */
public interface DrawingEngine {
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    //public Shape CloneShape();
    public Shape[] getShapes(); //returns created shapes object
    public void refresh(java.awt.Graphics canvas);// redraw
    public void save(String filename);
}
