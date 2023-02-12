package model;

import java.awt.*;

import view.MousePoint;
import view.gui.PaintCanvas;

public class SelectRectOutline {
    public void draw(int startMousePointX,int startMousePointY,int width,int height,PaintCanvas canvas){
        MousePoint startPoint=new MousePoint(startMousePointX-4,startMousePointY-4);
        MousePoint endPoint=new MousePoint(startMousePointX+width+4,startMousePointY+height+4);
        Graphics2D graphics2d=canvas.getGraphics2D();
        Stroke stroke=new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,new float[]{10},0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(startPoint.getXPoint(),startPoint.getYPoint(),Math.abs(startPoint.getXPoint()-endPoint.getXPoint()),Math.abs(startPoint.getYPoint()-endPoint.getYPoint()));
    }
}
