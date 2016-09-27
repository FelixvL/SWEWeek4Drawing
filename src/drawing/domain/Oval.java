
package drawing.domain;

import drawing.domain.DrawingItem;
import java.awt.Color;
import java.awt.Point;

public class Oval extends DrawingItem{
    private double width;
    private double height;    
    Oval(Point anchor, Color color, double width, double height ){
        super(anchor, color);
        this.width = width;
        this.height = height;
    }
    @Override
    void saveOldState(){
        Oval temp = new Oval(this.getAnchor(), this.getColor(), this.getWidth(), this.getHeight());
        System.out.println("Old State Saved: "+temp);
        this.setPreviousState(temp);
    }
    @Override
    boolean returnToPreviousState(){
        if(this.getPreviousState() != null){
            Oval previous = (Oval)getPreviousState();
            this.anchor = previous.getAnchor();
            this.color = previous.getColor();
            this.height = previous.height;
            this.width = previous.width;
            this.setPreviousState(previous.getPreviousState());
            System.out.println("Oval 1 state back");
            return true;
        }else{
            System.out.println("reverse not allowed");
            return false;
        } 
    }
    @Override
    public String toString(){
        return "Oval of size w: "+this.width+" and h: "+this.height+" at Point "+ this.getAnchor();
    }

    
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        saveOldState();
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        saveOldState();
        this.height = height;
    }    
}
