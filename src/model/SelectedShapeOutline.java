package model;

import model.ShapeOutline.SelectEllipseOutline;
import model.ShapeOutline.SelectRectOutline;
import model.ShapeOutline.SelectTriangleOutline;
import model.interfaces.IGroupedShapeHistory;
import model.interfaces.ISelectedShapeOutline;
import model.interfaces.IShape;
import view.MousePoint;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectedShapeOutline implements ISelectedShapeOutline, IGroupedShapeHistory {
    PaintCanvas canvas;
    static boolean isGrouped;
    List<Double> deg=new ArrayList<>();
    List<Integer> startX=new ArrayList<>(),startY=new ArrayList<>(),endX=new ArrayList<>(),endY=new ArrayList<>(),startXList=new ArrayList<>(),startYList=new ArrayList<>();
    int startPointX,startPointY,width,height;
    List<IShape> remove=new ArrayList<>();
    @Override
    public void shapeOutline() {
            isGrouped = false;
            for (IShape tempShape2 : SelectedShapeList.selectedShapes) {
                isGrouped = false;
                for (GroupedShapes groupedShapes : groupedShapesList) {
                    for (IShape shape : groupedShapes.getList()) {
                        if (shape == tempShape2) {
                            isGrouped = true;
                            startX.add(shape.getStartPoint().getXPoint());
                            startY.add(shape.getStartPoint().getYPoint());
                            endX.add(shape.getEndPoint().getXPoint());
                            endY.add(shape.getEndPoint().getYPoint());
                            deg.add(shape.getRotate());
                            startXList.add(Math.min(Collections.min(startX), Collections.max(endX)));
                            startYList.add(Math.min(Collections.min(startY), Collections.max(endY)));
                            remove.add(shape);
                        }
                    }
                }
                
                canvas=tempShape2.getPaintCanvas();
            }
            if (isGrouped) {
                int xMaxIndex=startXList.indexOf(Collections.max(startXList).intValue());
                int yMaxIndex=startYList.indexOf(Collections.min(startYList).intValue());
                canvas=remove.get(xMaxIndex).getPaintCanvas();
                startPointX = remove.get(xMaxIndex).getStartPointX();
                startPointY =remove.get(yMaxIndex).getStartPointY();
                width = Math.abs(Collections.min(startX)-Collections.max(endX));
                height = Math.abs(Collections.min(startY)-Collections.max(endY));
                
                ShapeOutline.SelectRectOutline.draw(startPointX,startPointY,width,height,Collections.max(deg).doubleValue(),canvas);
                        
              
            }
        
        for (IShape tempShape1 : ShapeHistoryList.shapeList) {
            for (IShape tempShape2 : SelectedShapeList.selectedShapes) {
                boolean found=false;
                for (GroupedShapes groupedShapes : groupedShapesList) {
                    for (IShape shape : groupedShapes.getList()) {
                        if(shape==tempShape2){
                            found=true;
                        }
                    }
                }
                if (tempShape2.equals(tempShape1) && !found) {
                    if (tempShape2 instanceof DrawRectangle) {
                        ShapeOutline.SelectRectOutline.draw(tempShape2.getStartPointX(), tempShape2.getStartPointY(),
                                tempShape2.getWidth(), tempShape2.getHeight(),tempShape2.getRotate() ,tempShape2.getPaintCanvas());
                    } else if (tempShape2 instanceof DrawEllipses) {
                        ShapeOutline.SelectEllipseOutline.draw(tempShape2.getStartPointX(), tempShape2.getStartPointY(),
                                tempShape2.getWidth(), tempShape2.getHeight(),tempShape2.getRotate(), tempShape2.getPaintCanvas());
                    } else if (tempShape2 instanceof DrawTriangle) {
                        DrawTriangle triangle = (DrawTriangle) tempShape2;
                        ShapeOutline.SelectTriangleOutline.draw(triangle.getXPoints(), triangle.getYPoints(),tempShape2.getRotate(),
                                tempShape2.getPaintCanvas());
                    }
                }

            }
        }
     
    }
}
