package drawing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawing {
    private String name;
    private int width;
    private int height;
    private List<DrawingItem> drawingItems;

    Drawing(){
        drawingItems = new ArrayList<DrawingItem>();
        System.out.println("New Drawing Created by Twan and Felix");
    }
    void paint(IPaintable paintable){
    
    }
    
    public boolean addDrawingItem(DrawingItem di){        
        drawingItems.add(di);
        System.out.println("New DI added of class: "+di.getClass() +" describe "+ di);
        return true;
    }
    @Override
    public String toString(){
        return this.name +": of size w: "+this.width+" and h: "+this.height;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    List<DrawingItem> getDrawingItems(){
        //return (List<DrawingItem>) Collections.unmodifiableList(drawingItems);
        return drawingItems;
    }
}
