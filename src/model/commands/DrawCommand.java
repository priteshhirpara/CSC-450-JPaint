package model.commands;

import java.awt.Color;

import model.DrawRectangle;
import model.ShapeHistoryList;
import model.persistence.ApplicationState;
import view.MousePoint;
import view.gui.PaintCanvas;

public class DrawCommand implements ICommand{
    MousePoint startMousePoint;
    MousePoint endMousePoint;
    PaintCanvas canvas;
    ApplicationState applicationState;
    public DrawCommand(MousePoint startMousePoint, MousePoint endMousePoint, PaintCanvas canvas,
            ApplicationState applicationState) {
        this.startMousePoint = startMousePoint;
        this.endMousePoint = endMousePoint;
        this.canvas = canvas;
        this.applicationState = applicationState;
    }
    public void run(){
        switch(applicationState.getActiveShapeType()){
            case RECTANGLE:
                DrawRectangle drawRectangle=new DrawRectangle(startMousePoint, endMousePoint, Color.BLUE, canvas);
                drawRectangle.draw();
                CommandHistory.add(drawRectangle);
                ShapeHistoryList.shapeList.add(drawRectangle);
            break;
        }
    }   
}
