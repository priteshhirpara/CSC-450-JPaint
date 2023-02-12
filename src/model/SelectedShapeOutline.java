package model;


import model.interfaces.ISelectedShapeOutline;
import model.interfaces.IShape;

public class SelectedShapeOutline implements ISelectedShapeOutline{
    SelectRectOutline drawRectOutline=new SelectRectOutline();
    SelectEllipseOutline drawEllipseOutline=new SelectEllipseOutline();
    SelectTriangleOutline drawTriangleOutline=new SelectTriangleOutline();
    
    @Override
    public void shapeOutline() {
      for(IShape tempShape1:ShapeHistoryList.shapeList){
        for(IShape tempShape2:SelectedShapeList.selectedShapes){
            if(tempShape2.equals(tempShape1)){
                if(tempShape2 instanceof DrawRectangle){
                   drawRectOutline.draw(tempShape2.getStartPointX(),tempShape2.getStartPointY(),tempShape2.getWidth(),tempShape2.getHeight(),tempShape2.getPaintCanvas());
                }else if(tempShape2 instanceof DrawEllipses){
                    drawEllipseOutline.draw(tempShape2.getStartPointX(),tempShape2.getStartPointY(),tempShape2.getWidth(),tempShape2.getHeight(),tempShape2.getPaintCanvas());
                }else if(tempShape2 instanceof DrawTriangle){
                    DrawTriangle triangle=(DrawTriangle)tempShape2;
                    drawTriangleOutline.draw(triangle.getXPoints(),triangle.getYPoints(),tempShape2.getPaintCanvas());
                }
            }
        }
      }
        
    }
    
}
