package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.GroupedShapes;
import model.SelectedShapeOutline;
import model.interfaces.ICommand;
import model.interfaces.IGroupedShapeHistory;
import model.interfaces.ISelectedShapeCommandHistory;
import model.interfaces.ISelectedShapesList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class GroupCommand implements ICommand, ISelectedShapeCommandHistory, IGroupedShapeHistory, IUndoable {
    GroupedShapes groupedShapes = new GroupedShapes();

    @Override
    public void run() {
        if (ISelectedShapesList.selectedShapes.size() > 1) {
            for (IShape iShape : ISelectedShapesList.selectedShapes) {
                
                    groupedShapes.add(iShape);
                
            }
            if (groupedShapes.getList().size() > 0) {
                groupedShapesList.add(groupedShapes);
                CommandHistory.add(this);
                SelectedShapeOutline outline=new SelectedShapeOutline();
                outline.shapeOutline();
                
            }
        }
    }

    @Override
    public void undo() {
        for (IShape iShape : ISelectedShapesList.selectedShapes) {
            groupedShapes.remove(iShape);
        }
        groupedShapesList.remove(groupedShapes);

    }

    @Override
    public void redo() {
        for (IShape iShape : ISelectedShapesList.selectedShapes) {
            groupedShapes.add(iShape);
        }
        groupedShapesList.add(groupedShapes);
    }

}
