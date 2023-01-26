package model.commands;

import model.persistence.ApplicationState;
import view.MousePoint;
import view.gui.PaintCanvas;

public class CurrentMouseMode {
  private static ICommand command;
  private static PaintCanvas canvas;
  public static void currentMode(MousePoint startPoint,MousePoint endPoint,PaintCanvas canvas,ApplicationState applicationState){
    switch(applicationState.getActiveMouseMode()){
      case DRAW:
        command=new DrawCommand(startPoint,endPoint,canvas,applicationState);
        command.run();
      break;
    }
  }
}
