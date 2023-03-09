package model;


import model.ShapeOutline.SelectEllipseOutline;
import model.ShapeOutline.SelectRectOutline;
import model.ShapeOutline.SelectTriangleOutline;
import model.interfaces.ISelectedShapeOutline;
import model.interfaces.IShape;
import view.MousePoint;
import view.gui.PaintCanvas;

import java.awt.*;

public class SelectedShapeOutline implements ISelectedShapeOutline{
   
    
    @Override
    public void shapeOutline() {
      for(IShape tempShape1:ShapeHistoryList.shapeList){
        for(IShape tempShape2:SelectedShapeList.selectedShapes){
            if(tempShape2.equals(tempShape1)){
                if(tempShape2 instanceof DrawRectangle){
                   ShapeOutline.SelectRectOutline.draw(tempShape2.getStartPointX(),tempShape2.getStartPointY(),tempShape2.getWidth(),tempShape2.getHeight(),tempShape2.getPaintCanvas());
                }else if(tempShape2 instanceof DrawEllipses){
                    ShapeOutline.SelectEllipseOutline.draw(tempShape2.getStartPointX(),tempShape2.getStartPointY(),tempShape2.getWidth(),tempShape2.getHeight(),tempShape2.getPaintCanvas());
                }else if(tempShape2 instanceof DrawTriangle){
                    DrawTriangle triangle=(DrawTriangle)tempShape2;
                    ShapeOutline.SelectTriangleOutline.draw(triangle.getXPoints(),triangle.getYPoints(),tempShape2.getPaintCanvas());
                }
            }
        }
      }
        
    }    
}
