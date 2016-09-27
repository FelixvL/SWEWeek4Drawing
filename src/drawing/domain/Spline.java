
package drawing.domain;

import java.awt.Color;
import java.awt.Point;

public class Spline extends DrawingItem {
    private Point[] points;
    private int weight;
    private int degree;
    
    Spline(Point anchor, Color color, Point[] points, int weight, int degree){
        super(anchor, color);
        this.points = points;
        this.weight = weight;
        this.degree = degree;
    }
    @Override
    void saveOldState(){
        Spline temp = new Spline(this.getAnchor(), this.getColor(), this.getPoints(), this.getWeight(), this.getDegree());
        System.out.println("Old State Saved: "+temp);
        this.setPreviousState(temp);
    }
    @Override
    boolean returnToPreviousState(){
        if(this.getPreviousState() != null){
            Spline previous = (Spline)getPreviousState();
            this.anchor = previous.getAnchor();
            this.color = previous.getColor();
            this.points = previous.points;
            this.weight = previous.weight;
            this.degree = previous.degree;
            this.setPreviousState(previous.getPreviousState());
            System.out.println("Spline 1 state back");
            return true;
        }else{
            System.out.println("reverse not allowed");
            return false;
        } 
    }
    
    @Override
    public String toString(){
        return "Spline of weight: "+this.weight+" and degree: "+this.degree + " at Point "+ this.getAnchor();
    }

    public Point[] getPoints() {
        return points;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        saveOldState();
        this.weight = weight;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        saveOldState();
        this.degree = degree;
    }    

    @Override
    void paint(IPaintable paintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
