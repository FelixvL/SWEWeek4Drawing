package drawing.domain;

import java.awt.Color;
import java.awt.Point;
 

public abstract class DrawingItem implements Comparable<DrawingItem> {
    protected Point anchor;
    protected Color color;
    private DrawingItem previousState;
    
    DrawingItem(Point anchor, Color color){
        this.anchor = anchor;
        this.color = color;
        previousState = null;
    }
    abstract void paint(IPaintable paintable);
    
    abstract void saveOldState();
    abstract boolean returnToPreviousState();
    public int compareTo(DrawingItem di){
        if(this.anchor.x < di.anchor.x){
            return 1;
        }else if(this.anchor.x > di.anchor.x){
            return -1;
        }else{
            if(this.anchor.y < di.anchor.y){
                return 1;
            }else if(this.anchor.x > di.anchor.x){
                return -1;
            }
        }
        return 0;
    }
    public Point getAnchor() {
        return anchor;
    }
    public void setAnchor(Point anchor) {
        saveOldState();
        this.anchor = anchor;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        saveOldState();
        this.color = color;
    }

    public DrawingItem getPreviousState() {
        return previousState;
    }

    public void setPreviousState(DrawingItem previousState) {
        this.previousState = previousState;
    }
}
