package model.commands;

import model.SelectedOutline;
import model.interfaces.ICommand;
import model.interfaces.ISelectedShapeOutline;
import model.persistence.ApplicationState;
import view.MousePoint;
import view.gui.PaintCanvas;

public class CurrentMouseMode {
  private static ICommand command;
  private static PaintCanvas canvas;
  static SelectedOutline selectOutline=null;
  static SelectedOutline moveOutline=null;
  public static void currentMode(MousePoint startPoint,MousePoint endPoint,PaintCanvas canvas,ApplicationState applicationState){

    switch(applicationState.getActiveMouseMode()){
      case DRAW:
        command=new DrawCommand(startPoint,endPoint,canvas,applicationState);
        command.run();
      break;
      case SELECT:
        command=new SelectCommand(startPoint,endPoint,canvas);
        command.run();
        selectOutline=new SelectedOutline(command);
        showOutline(selectOutline);
      break;
      case MOVE:
        command=new MoveCommand(startPoint, endPoint, canvas);
        command.run();
        moveOutline=new SelectedOutline(command);
        showOutline(moveOutline);
    }
  }
  public static void showOutline(ISelectedShapeOutline selectedShapeOutline){
    selectedShapeOutline.shapeOutline();
  }
}
