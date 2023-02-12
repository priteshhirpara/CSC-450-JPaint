package model.commands;

import java.awt.Color;

import model.DrawEllipses;
import model.DrawRectangle;
import model.DrawTriangle;
import model.ShapeColor;
import model.ShapeHistoryList;
import model.ShapeShadingType;
import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import view.MousePoint;
import view.gui.PaintCanvas;

public class DrawCommand implements ICommand{
    MousePoint startMousePoint;
    MousePoint endMousePoint;
    PaintCanvas canvas;
    ApplicationState applicationState;
    String shadeType;
    Color primaryColor;
    Color secondaryColor;
    public DrawCommand(MousePoint startMousePoint, MousePoint endMousePoint, PaintCanvas canvas,
            ApplicationState applicationState) {
        this.startMousePoint = startMousePoint;
        this.endMousePoint = endMousePoint;
        this.canvas = canvas;
        this.applicationState = applicationState;
        
        if(applicationState.getActiveShapeShadingType()==ShapeShadingType.FILLED_IN){
            this.shadeType="FILLED_IN";
        }
        else if(applicationState.getActiveShapeShadingType()==ShapeShadingType.OUTLINE){
            this.shadeType="OUTLINE";
        }else if(applicationState.getActiveShapeShadingType()==ShapeShadingType.OUTLINE_AND_FILLED_IN){
            this.shadeType="OUTLINE_AND_FILLED_IN";
        }
        
    }
    public void run(){
        primaryColor=ShapeColor.colors.get(applicationState.getActivePrimaryColor());
        secondaryColor=ShapeColor.colors.get(applicationState.getActiveSecondaryColor());
        switch(applicationState.getActiveShapeType()){
            case RECTANGLE:
                DrawRectangle drawRectangle=new DrawRectangle(startMousePoint, endMousePoint, primaryColor,secondaryColor,shadeType, canvas);
                drawRectangle.draw();
                CommandHistory.add(drawRectangle);
                ShapeHistoryList.shapeList.add(drawRectangle);
            break;
            case TRIANGLE:
                DrawTriangle drawTriangle=new DrawTriangle(startMousePoint, endMousePoint, primaryColor,secondaryColor,shadeType, canvas);
                drawTriangle.draw();
                CommandHistory.add(drawTriangle);
                ShapeHistoryList.shapeList.add(drawTriangle);
            break;
            case ELLIPSE:
                 DrawEllipses drawEllipses=new DrawEllipses(startMousePoint, endMousePoint, primaryColor,secondaryColor,shadeType, canvas);
                 drawEllipses.draw();
                 CommandHistory.add(drawEllipses);
                 ShapeHistoryList.shapeList.add(drawEllipses);
            break;
        }
    }   
}
