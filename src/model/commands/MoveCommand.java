package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.ShapeHistory;
import model.ShapeHistoryList;
import model.interfaces.ICommand;
import model.interfaces.ISelectedShapesList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.MousePoint;
import view.gui.PaintCanvas;

public class MoveCommand implements ICommand,IUndoable,ISelectedShapesList {
    private final PaintCanvas canvas;
    private int xPoints;
    private int yPoints;
    private MousePoint startPoint;
    private MousePoint endPoint;
    private static boolean moveOptionSelected=false;
    private static boolean undoOptionSelected=false;
    private static boolean redoOptionSelected=false;
    private List<IShape> moveShapeList;
    private List<IShape> removeShapeList;
    public MoveCommand(MousePoint startPoint,MousePoint endPoint,PaintCanvas canvas){
        this.canvas=canvas;
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        moveShapeList=new ArrayList<>();
        removeShapeList=new ArrayList<>();
    }
    @Override
    public void undo() {
        redoOptionSelected=false;
        undoOptionSelected=moveShapeList.size()>0;
        for(IShape tempShape1:moveShapeList){
            selectedShapes.remove(tempShape1);
            ShapeHistoryList.shapeList.remove(tempShape1);
        }
        for (IShape tempShape1 : removeShapeList) {
            tempShape1.updatePoints(0-xPoints, 0-yPoints);
            selectedShapes.add(tempShape1);
            ShapeHistoryList.shapeList.add(tempShape1);
        }
        if(canvas!=null){
            canvas.refresh(canvas);
        }
        
    }
    public static boolean isMoveOptionSelected(){
        return moveOptionSelected;
    }
    public static void setMoveOptionSelected(boolean moveOptionSelected){
        MoveCommand.moveOptionSelected=moveOptionSelected;
    }
    public static boolean isUndoOptionSelected(){
        return undoOptionSelected;
    }
    public static void setUndoOptionSelected(boolean undoOptionSelected){
        MoveCommand.undoOptionSelected=undoOptionSelected;
    }
    public static boolean isRedoOptionSelected(){
        return redoOptionSelected;
    }
    public static void setRedoOptionSelected(boolean redoOptionSelected){
        MoveCommand.redoOptionSelected=redoOptionSelected;
    }
    public MousePoint getNewStartPoint(){
      return startPoint;  
    }
    public MousePoint getNewEndPoint(){
        return endPoint;
    }
    public PaintCanvas gePaintCanvas(){
        return canvas;
    }
    @Override
    public void redo() {
        undoOptionSelected=false;
        redoOptionSelected=moveShapeList.size()>0;
        for(IShape tempShape1:removeShapeList){
            selectedShapes.remove(tempShape1);
            ShapeHistoryList.shapeList.remove(tempShape1);
        }
        for (IShape tempShape1 : moveShapeList) {
            tempShape1.updatePoints(0-xPoints, 0-yPoints);
            selectedShapes.add(tempShape1);
            ShapeHistoryList.shapeList.add(tempShape1);
        }
        if(canvas!=null){
            canvas.refresh(canvas);
        }   
    }

    @Override
    public void run() {
        undoOptionSelected=false;
        redoOptionSelected=false;
        xPoints=endPoint.getXPoint()-startPoint.getXPoint();
        yPoints=endPoint.getYPoint()-startPoint.getYPoint();
        
        for (IShape tempShape1 : selectedShapes) {
            for (IShape tempShape2 : ShapeHistoryList.shapeList) {
                if(tempShape1.equals(tempShape2)){
                    removeShapeList.add(tempShape2);
                    tempShape1.updatePoints(xPoints, yPoints);
                    moveShapeList.add(tempShape1);
                }
            }
        }
        for (IShape tempShape1 : removeShapeList) {
            selectedShapes.remove(tempShape1);
            ShapeHistoryList.shapeList.remove(tempShape1);
            
        }
        for (IShape tempShape1 : moveShapeList) {
            selectedShapes.add(tempShape1);
            ShapeHistoryList.shapeList.add(tempShape1);
            canvas.refresh(canvas);
            moveOptionSelected=selectedShapes.size()>0;
            CommandHistory.add(this);
        }
    }

    
}
