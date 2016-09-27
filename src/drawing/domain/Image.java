
package drawing.domain;

import java.awt.Color;
import java.awt.Point;
import java.io.File;

public class Image extends DrawingItem{
    private File file;
    private double size;
    Image(Point anchor, Color color, File file, double size){
        super(anchor, color);
        this.file = file;
        this.size = size;
    }
    
    public void paint(IPaintable paintable){
        
    }
    
        @Override
    void saveOldState(){
        Image temp = new Image(this.getAnchor(), this.getColor(), this.getFile(), this.getSize());
        System.out.println("Old State Saved: "+temp);
        this.setPreviousState(temp);
    }
    @Override
    boolean returnToPreviousState(){
        if(this.getPreviousState() != null){
            Image previous = (Image)getPreviousState();
            this.anchor = previous.getAnchor();
            this.color = previous.getColor();
            this.file = previous.file;
            this.size = previous.size;
            this.setPreviousState(previous.getPreviousState());
            System.out.println("Image 1 state back");
            return true;
        }else{
            System.out.println("reverse not allowed");
            return false;
        } 
    }
    
    @Override
    public String toString(){
        return "Image with file: "+this.file+" of size: "+this.size + " at Point "+ this.getAnchor();
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        saveOldState();
        this.file = file;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        saveOldState();
        this.size = size;
    }    
}
