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
    List<Integer> startX=new ArrayList<>(),startY=new ArrayList<>(),endX=new ArrayList<>(),endY=new ArrayList<>();
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
                            remove.add(shape);
                        }
                    }
                }
                
                canvas=tempShape2.getPaintCanvas();
            }
            if (isGrouped) {
                startPointX = Math.min(Collections.min(startX), Collections.max(endX));
                startPointY = Math.min(Collections.min(startY), Collections.max(endY));
                width = Math.abs(Collections.min(startX)-Collections.max(endX));
                height = Math.abs(Collections.min(startY)-Collections.max(endY));
                ShapeOutline.SelectRectOutline.draw(startPointX,startPointY,width,height,canvas);
                        
              
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
                                tempShape2.getWidth(), tempShape2.getHeight(), tempShape2.getPaintCanvas());
                    } else if (tempShape2 instanceof DrawEllipses) {
                        ShapeOutline.SelectEllipseOutline.draw(tempShape2.getStartPointX(), tempShape2.getStartPointY(),
                                tempShape2.getWidth(), tempShape2.getHeight(), tempShape2.getPaintCanvas());
                    } else if (tempShape2 instanceof DrawTriangle) {
                        DrawTriangle triangle = (DrawTriangle) tempShape2;
                        ShapeOutline.SelectTriangleOutline.draw(triangle.getXPoints(), triangle.getYPoints(),
                                tempShape2.getPaintCanvas());
                    }
                }

            }
        }

    }
}
