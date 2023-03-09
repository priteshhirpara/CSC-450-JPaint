package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.GroupedShapes;
import model.SelectedShapeList;
import model.SelectedShapeOutline;
import model.ShapeOutline;
import model.interfaces.ICommand;
import model.interfaces.IGroupedShapeHistory;
import model.interfaces.ISelectedShapeCommandHistory;
import model.interfaces.ISelectedShapesList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class UnGroupCommand implements ICommand,IGroupedShapeHistory,IUndoable{
    List<GroupedShapes> ungrouped=new ArrayList<>();
    GroupedShapes gShapes;
    boolean found=false;
    @Override
    public void run() {
        for (GroupedShapes groupedShapes : groupedShapesList) {
            for (IShape shape : groupedShapes.getList()) {
                for (IShape iShape : ISelectedShapesList.selectedShapes) {
                    if(iShape==shape){
                        gShapes=groupedShapes;
                        found=true;
                    }
                }
            }
        }
        if(found){
        ungrouped.add(gShapes);
        groupedShapesList.remove(gShapes);      
        SelectedShapeList.selectedShapes.clear();
        SelectedShapeList.selectedShapes.addAll(gShapes.getList());
        SelectedShapeOutline outline=new SelectedShapeOutline();
        outline.shapeOutline();
        }
    }

    @Override
    public void undo() {
        groupedShapesList.add(gShapes);
        ungrouped.remove(gShapes);
    }

    @Override
    public void redo() {
        ungrouped.add(gShapes);
        groupedShapesList.remove(gShapes);
    }
    
}
