package model.commands;

import model.SelectedShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

public class AnimationCommand implements ICommand {
    private Timer timer;
    public static boolean animFlag=false;
    @Override
    public void run(){
        animFlag=!animFlag;
        
           
            timer = new Timer(20, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                   if (animFlag) {
                    for (int i = 0; i < SelectedShapeList.selectedShapes.size(); i++) {
                        IShape shape=SelectedShapeList.selectedShapes.get(i);
                        shape.rotate(shape.getRotate()+((2*Math.PI)+0.01));    
                        shape.getPaintCanvas().refresh(shape.getPaintCanvas());
                    }
                   }
                }
             });
             timer.start();

    }
   
}
