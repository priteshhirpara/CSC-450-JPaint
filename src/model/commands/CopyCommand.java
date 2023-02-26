package model.commands;

import model.interfaces.ICommand;
import model.interfaces.ISelectedShapeCommandHistory;
import model.interfaces.ISelectedShapesList;

public class CopyCommand implements ICommand,ISelectedShapeCommandHistory{

    @Override
    public void run() {
        selectedShapeCommandHistory.clear();
        selectedShapeCommandHistory.addAll(ISelectedShapesList.selectedShapes);
    }
    
}
