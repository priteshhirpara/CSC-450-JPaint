package model.commands;

import model.interfaces.ICommand;

public class RedoCommand implements ICommand {
    private static boolean redoOptionSelected=false;
    @Override
    public void run() {
      CommandHistory.redo();
        
    }
    public static boolean isRedoOptionSelected(){
      return redoOptionSelected;
  }
  public static void setRedoOptionSelected(boolean redoOptionSelected){
      RedoCommand.redoOptionSelected=redoOptionSelected;
  }   
}
