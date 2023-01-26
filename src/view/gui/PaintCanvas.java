package view.gui;

import javax.swing.JComponent;

import model.ShapeHistoryList;
import model.interfaces.IShape;

import java.awt.*;

public class PaintCanvas extends JComponent {

    // @Override
    // public void paint(Graphics g) {
    //     Graphics2D graphics2d = (Graphics2D)g;
        
        
    // }
    public Graphics2D getGraphics2D(){
        return (Graphics2D)getGraphics();
    }
    public static void refresh(PaintCanvas canvas){
            Graphics2D graphics2d = canvas.getGraphics2D();
            graphics2d.setColor(Color.white);
            graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    
          
    
            for(IShape shape: ShapeHistoryList.shapeList) {
                shape.draw();
            }
        
    }
}
