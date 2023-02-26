package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.SelectedShapeList;
import model.ShapeHistoryList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

public class DeleteCommand implements ICommand,IUndoable{
    List<IShape> deletedShapes=new ArrayList<>();
    @Override
    public void run() {
        deletedShapes.addAll(SelectedShapeList.selectedShapes);
        for (IShape iShape : deletedShapes) {
            SelectedShapeList.selectedShapes.remove(iShape);
            ShapeHistoryList.shapeList.remove(iShape);
            PaintCanvas.refresh(iShape.getPaintCanvas());
        }   
        
        CommandHistory.add(this);
    }
    @Override
    public void undo() {
        for(IShape iShape:deletedShapes){
            ShapeHistoryList.shapeList.add(iShape);
            PaintCanvas.refresh(iShape.getPaintCanvas());
        }
    }

    @Override
    public void redo() {
        for(IShape iShape:deletedShapes){
            ShapeHistoryList.shapeList.remove(iShape);
            PaintCanvas.refresh(iShape.getPaintCanvas());
        }
    }

    
    
}
