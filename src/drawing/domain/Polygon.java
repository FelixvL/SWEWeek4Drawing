
package drawing.domain;

import java.awt.Color;
import java.awt.Point;

public class Polygon extends DrawingItem{
    private Point[] vertices;
    private int weight;
    
    Polygon(Point anchor, Color color, Point[] vertices, int weight){
        super(anchor, color);
        this.vertices = vertices;
        this.weight = weight;
    }
    @Override
    void saveOldState(){
        Polygon temp = new Polygon(this.getAnchor(), this.getColor(), this.getVertices(), this.getWeight());
        System.out.println("Old State Saved: "+temp);
        this.setPreviousState(temp);
    }
    @Override
    boolean returnToPreviousState(){
        if(this.getPreviousState() != null){
            Polygon previous = (Polygon)getPreviousState();
            this.anchor = previous.getAnchor();
            this.color = previous.getColor();
            this.vertices = previous.vertices;
            this.weight = previous.weight;
            this.setPreviousState(previous.getPreviousState());
            System.out.println("Polygon 1 state back");
            return true;
        }else{
            System.out.println("reverse not allowed");
            return false;
        } 
    }
    
    @Override
    public String toString(){
        return "Polygon of weight: "+this.weight + " at Point "+ this.getAnchor();
    }
    
    public Point[] getVertices() {
        return vertices;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        saveOldState();
        this.weight = weight;
    }    

    @Override
    void paint(IPaintable paintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
