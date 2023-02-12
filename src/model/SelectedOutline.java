package model;

import model.commands.MoveCommand;
import model.commands.RedoCommand;
import model.commands.SelectCommand;
import model.commands.UndoCommand;
import model.interfaces.ICommand;
import model.interfaces.ISelectedShapeOutline;


public class SelectedOutline implements ISelectedShapeOutline {
    private ICommand command;
    private SelectedShapeOutline selectedShapeOutline;
    private SelectedShapeOutline movedShapeOutline;
    private SelectedShapeOutline undoShapeOutline;
    private SelectedShapeOutline redoShapeOutline;
    private SelectCommand selectCommand=null;
    private MoveCommand moveCommand=null;
    private UndoCommand undoCommand=null;
    private RedoCommand redoCommand=null;
    public SelectedOutline(ICommand command){
        this.command=command;
        if(command instanceof SelectCommand){
            selectCommand=(SelectCommand)command;
        }else if(command instanceof MoveCommand){
            moveCommand=(MoveCommand)command;
        }else if(command instanceof UndoCommand){
            undoCommand=(UndoCommand)command;
        }else if(command instanceof RedoCommand){
            redoCommand=(RedoCommand)command;
        }
    }
    @Override
    public void shapeOutline() {
        selectedShapeOutline=new SelectedShapeOutline();
        selectedShapeOutline.shapeOutline();
    }

    
}
   
