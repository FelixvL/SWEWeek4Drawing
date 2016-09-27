package drawing.domain;

import drawing.domain.Oval;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DrawingApplicationWeek1 {
    Scanner scanner = new Scanner(System.in);
    Drawing drawing;
    Point defaultAnchor = new Point(10,10);
    Color defaultColor = new Color(22,22,22);
    Point[] defaultPoints = new Point[5];
    Font defaultFont = new Font("ariel", 30, 20);
    File defaultFile = new File("mapEnFile");
    
    public static void main(String[] args) {
       DrawingApplicationWeek1 daw1 = new DrawingApplicationWeek1();
        boolean continueProgram = true;
       daw1.drawing = new Drawing();
       daw1.printMenu();
       while(continueProgram){
            String input = daw1.scanner.nextLine();
            if(input.equals("q") || input.equals("")){
                continueProgram = false;
            }else{
                daw1.processInput(input);
            }
       }
    }
    void printMenu(){
        System.out.println("-- q -- quit");
        System.out.println("-- o -- to add oval     ");
        System.out.println("-- p -- to add polygon  ");
        System.out.println("-- s -- to add spline   ");
        System.out.println("-- t -- to add text     ");
        System.out.println("-- i -- to add image    ");
        System.out.println("-- m -- to modify    ");
        
    }
    void processInput(String input){
        switch(input.substring(0,1)){
            case "o":
                handleOval(input);
                break;
            case "p":
                handlePolygon(input);
                break;
            case "s":
                handleSpline(input);
                break;
            case "t":
                handleText(input);
                break;
            case "i":
                handleImage(input);
                break;
            case "m":
                modifyItems(input);
                break;
            default:
                printMenu();
                break;
        }
    }
    void handleOval(String input){
        if(true){
            Oval oval = new Oval(defaultAnchor, defaultColor, 30, 30);
            drawing.addDrawingItem(oval);
        }
    }
    void handlePolygon(String input){
        if(true){
            Polygon polygon = new Polygon(defaultAnchor, defaultColor, defaultPoints, 20);
            drawing.addDrawingItem(polygon);
        }
    }
    void handleSpline(String input){
        if(true){
            Spline spline = new Spline(defaultAnchor, defaultColor, defaultPoints, 10, 40);
            drawing.addDrawingItem(spline);
        }
    }
    void handleText(String input){
        if(true){
            PaintedText pText = new PaintedText(defaultAnchor, defaultColor, "Default Text", defaultFont);
            drawing.addDrawingItem(pText);
        }
    }
    void handleImage(String input){
        if(true){
            Image image = new Image(defaultAnchor, defaultColor, defaultFile, 25.0);
            drawing.addDrawingItem(image);
        }
    }
    void modifyItems(String input){
        if(true){
            List<DrawingItem> di_s = drawing.getDrawingItems();
             Collections.sort(di_s);
            for(DrawingItem di : di_s){
                System.out.println(di_s.indexOf(di)+" "+di);
            }
            System.out.println("--0p45p56-- to change AnchorPoint");
            System.out.println("--0r-- to go step back");
            String choiceItem = scanner.nextLine();
            if(choiceItem.substring(1, 2).equals("p")){
                String[] choiceElements = choiceItem.split("p");
                int index = Integer.parseInt(choiceElements[0]);
                int pointX = Integer.parseInt(choiceElements[1]);
                int pointY = Integer.parseInt(choiceElements[2]);
                DrawingItem di = di_s.get(index);
                Point newAnchorPoint = new Point(pointX, pointY);
                di.setAnchor(newAnchorPoint);
            }else if(choiceItem.substring(1, 2).equals("r")){
                int index = Integer.parseInt(choiceItem.substring(0,1));
                DrawingItem di = di_s.get(index);
                di.returnToPreviousState();
            }
        }
    }
}
