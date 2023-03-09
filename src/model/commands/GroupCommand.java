package model.commands;

import java.util.ArrayList;
import java.util.List;

import model.GroupedShapes;
import model.interfaces.ICommand;
import model.interfaces.IGroupedShapeHistory;
import model.interfaces.ISelectedShapeCommandHistory;
import model.interfaces.ISelectedShapesList;
import model.interfaces.IShape;

public class GroupCommand implements ICommand,ISelectedShapeCommandHistory,IGroupedShapeHistory{
   
    @Override
    public void run() {
       GroupedShapes groupedShapes=new GroupedShapes();
       for (IShape iShape : ISelectedShapesList.selectedShapes) {
            groupedShapes.add(iShape);
       }
       groupedShapesList.add(groupedShapes);
    }
    
}
