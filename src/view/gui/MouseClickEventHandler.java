package view.gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.commands.CurrentMouseMode;
import model.persistence.ApplicationState;
import view.MousePoint;

public class MouseClickEventHandler extends MouseAdapter {
        private MousePoint mouseStartPoint;
        private MousePoint mouseEndPoint;
        private static PaintCanvas paintCanvas;
        private static ApplicationState applicationState;
        private static MouseClickEventHandler clickEventHandler;
        private MouseClickEventHandler(PaintCanvas paintCanvas,ApplicationState applicationState){
            this.paintCanvas=paintCanvas;
            this.applicationState=applicationState;
        }
        public static MouseClickEventHandler getInstance(PaintCanvas paintCanvas,ApplicationState applicationState){
            if(clickEventHandler==null){
                clickEventHandler=new MouseClickEventHandler(paintCanvas,applicationState);
            }
            return clickEventHandler;
        }
        public void mousePressed(MouseEvent e){
            mouseStartPoint=new MousePoint(e.getX(), e.getY());
        }
        public void mouseReleased(MouseEvent e){
            mouseEndPoint=new MousePoint(e.getX(),e.getY());
            CurrentMouseMode.currentMode(mouseStartPoint, mouseEndPoint, paintCanvas, applicationState);
        }

}
