
package drawing.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class PaintedText extends DrawingItem {
    private String content;
    private Font font;
    
    PaintedText(Point anchor, Color color, String content, Font font){
        super(anchor, color);
        this.content = content;
        this.font = font;
    }
    
    @Override
    void saveOldState(){
        PaintedText temp = new PaintedText(this.getAnchor(), this.getColor(), this.getContent(), this.getFont());
        System.out.println("Old State Saved: "+temp);
        this.setPreviousState(temp);
    }
    @Override
    boolean returnToPreviousState(){
        if(this.getPreviousState() != null){
            PaintedText previous = (PaintedText)getPreviousState();
            this.anchor = previous.getAnchor();
            this.color = previous.getColor();
            this.content = previous.content;
            this.font = previous.font;
            this.setPreviousState(previous.getPreviousState());
            System.out.println("PaintedText 1 state back");
            return true;
        }else{
            System.out.println("reverse not allowed");
            return false;
        } 
    }
    
    @Override
    public String toString(){
        return "PaintedText of content: "+this.content  + " at Point "+ this.getAnchor();
    }

 
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        saveOldState();
        this.content = content;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        saveOldState();
        this.font = font;
    }   

    @Override
    void paint(IPaintable paintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
