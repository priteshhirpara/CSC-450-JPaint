package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.DrawEllipses;
import model.DrawRectangle;
import model.DrawTriangle;
import model.SelectedShapeList;
import model.SelectedShapeOutline;
import model.ShapeHistoryList;
import model.interfaces.ICommand;
import model.interfaces.ISelectedShapeCommandHistory;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.MousePoint;
import view.gui.PaintCanvas;

public class PasteCommand implements ICommand,ISelectedShapeCommandHistory,IUndoable {
    SelectedShapeOutline selectedShapeOutline;
    List<IShape> pastedShapes=new ArrayList<>();
    @Override
    public void run() {
        for (IShape iShape : selectedShapeCommandHistory) {
            if(iShape instanceof DrawTriangle){
                DrawTriangle drawTriangle=new DrawTriangle(new MousePoint(iShape.getStartPoint().getXPoint()+50, iShape.getStartPoint().getYPoint()+50),new MousePoint(iShape.getEndPoint().getXPoint()+50, iShape.getEndPoint().getYPoint()+50),iShape.getPrimaryColor(),iShape.getSecondaryColor(),iShape.getShadeType(), iShape.getPaintCanvas());
                drawTriangle.draw();      
                pastedShapes.add(drawTriangle);  
            }else if(iShape instanceof DrawEllipses){
                DrawEllipses drawEllipses=new DrawEllipses(new MousePoint(iShape.getStartPoint().getXPoint()+50, iShape.getStartPoint().getYPoint()+50),new MousePoint(iShape.getEndPoint().getXPoint()+50, iShape.getEndPoint().getYPoint()+50),iShape.getPrimaryColor(),iShape.getSecondaryColor(),iShape.getShadeType(), iShape.getPaintCanvas());
                drawEllipses.draw();  
                pastedShapes.add(drawEllipses);   
            }else if(iShape instanceof DrawRectangle){
                DrawRectangle drawRectangle=new DrawRectangle(new MousePoint(iShape.getStartPoint().getXPoint()+50, iShape.getStartPoint().getYPoint()+50),new MousePoint(iShape.getEndPoint().getXPoint()+50, iShape.getEndPoint().getYPoint()+50),iShape.getPrimaryColor(),iShape.getSecondaryColor(),iShape.getShadeType(), iShape.getPaintCanvas());
                drawRectangle.draw();  
                pastedShapes.add(drawRectangle);  
            }
           
        }
        if(pastedShapes.size()>0){
            SelectedShapeList.selectedShapes.clear(); 
            for (IShape pShape : pastedShapes) {
                CommandHistory.add(this);    
                ShapeHistoryList.shapeList.add(pShape);
                PaintCanvas.refresh(pShape.getPaintCanvas());
                SelectedShapeList.selectedShapes.add(pShape);
            }
                selectedShapeOutline=new SelectedShapeOutline();
                selectedShapeOutline.shapeOutline();
           
        }
    }

    @Override
    public void undo() {
        
        for(IShape iShape:pastedShapes){
            ShapeHistoryList.shapeList.remove(iShape);
            PaintCanvas.refresh(iShape.getPaintCanvas());
        }
        
    }

    @Override
    public void redo() {
        for(IShape iShape:pastedShapes){
            ShapeHistoryList.shapeList.add(iShape);
            PaintCanvas.refresh(iShape.getPaintCanvas());
        }   
    }
    
}
