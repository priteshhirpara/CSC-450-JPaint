package model.commands;

import model.interfaces.ICommand;

public class UndoCommand implements ICommand {
private static boolean undoOptionSelected=false;
    @Override
    public void run() {
      CommandHistory.undo();
        
    }
   
  public static boolean isUndoOptionSelected(){
      return undoOptionSelected;
  }
  public static void setUndoOptionSelected(boolean undoOptionSelected){
      UndoCommand.undoOptionSelected=undoOptionSelected;
  }   
}
