package model.commands;

import java.util.List;

import model.GroupedShapes;
import model.ShapeHistoryList;
import model.interfaces.ICommand;
import model.interfaces.IGroupedShapeHistory;
import model.interfaces.ISelectedShapesList;
import model.interfaces.IShape;
import view.MousePoint;
import view.gui.PaintCanvas;

public class SelectCommand implements ICommand,ISelectedShapesList,IGroupedShapeHistory {
    private PaintCanvas canvas;
    private MousePoint startMousePoint;
    private MousePoint endMousePoint;
    private MousePoint minPoint;
    private int width;
    private int height;
    private static boolean isSelected=false;
    private static boolean isGrouped=false;
    GroupedShapes groupedShapes=new GroupedShapes();
    public SelectCommand(MousePoint startMousePoint,MousePoint endMousePoint,PaintCanvas canvas){
        this.startMousePoint=startMousePoint;
        this.endMousePoint=endMousePoint;
        this.canvas=canvas;
    }
    @Override
    public void run() {
        MoveCommand.setMoveOptionSelected(false);
        minPoint=new MousePoint(Math.min(startMousePoint.getXPoint(), endMousePoint.getXPoint()),Math.min(startMousePoint.getYPoint(), endMousePoint.getYPoint()));
        width=Math.abs(startMousePoint.getXPoint()-endMousePoint.getXPoint());
        height=Math.abs(startMousePoint.getYPoint()-endMousePoint.getYPoint());
        
        selectedShapes.clear();
        isSelected=false;
        canvas.refresh(canvas);
        selectedShapes.clear();
            for(IShape tempShape:ShapeHistoryList.shapeList){
                if(tempShape.getStartPointX()<minPoint.getXPoint()+width&&tempShape.getStartPointX()+tempShape.getWidth()>minPoint.getXPoint()&&tempShape.getStartPointY()<minPoint.getYPoint()+height&&tempShape.getStartPointY()+tempShape.getHeight()>minPoint.getYPoint()){
                    isGrouped=false;
                    for (GroupedShapes groupedShapes : groupedShapesList) {
                        for (IShape shape : groupedShapes.getList()) {
                            if(shape==tempShape){
                                isGrouped=true;
                            }
                        }
                    }
                    
                    if(isGrouped){
                        for (GroupedShapes groupedShapes : groupedShapesList) {
                            for (IShape shape : groupedShapes.getList()) {
                                if(shape==tempShape){
                                    selectedShapes.addAll(groupedShapes.getList());
                                }
                            }
                        }
                    }else{
                        selectedShapes.add(tempShape);
                        
                    }
                }
            }     
        isSelected=selectedShapes.size()>0;
    }
    public static boolean isSelected(){
        return isSelected;
    }
    public PaintCanvas gePaintCanvas(){
        return canvas;
    }
    public MousePoint getStarPoint(){
        return startMousePoint;
    }
    public MousePoint getEndPoint(){
        return endMousePoint;
    }
    
}
