package model.commands;

import model.SelectedShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;

public class RotateCommand implements ICommand,IUndoable {

    @Override
    public void run() {
       for (IShape shape : SelectedShapeList.selectedShapes) {
            shape.rotate(shape.getRotate()+Math.toRadians(90));
            shape.getPaintCanvas().refresh(shape.getPaintCanvas());
       }
       CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShape shape : SelectedShapeList.selectedShapes) {
            shape.rotate(shape.getRotate()-Math.toRadians(90));
            shape.getPaintCanvas().refresh(shape.getPaintCanvas());
       }
    }

    @Override
    public void redo() {
        for (IShape shape : SelectedShapeList.selectedShapes) {
            shape.rotate(shape.getRotate()+Math.toRadians(90));
            shape.getPaintCanvas().refresh(shape.getPaintCanvas());
       }
    }
    
}
