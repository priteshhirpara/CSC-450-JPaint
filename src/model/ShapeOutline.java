package model;

import view.MousePoint;
import view.gui.PaintCanvas;

import java.awt.*;
public class ShapeOutline {
    public static class SelectEllipseOutline {
        public static void draw(int startMousePointX,int startMousePointY,int width,int height,PaintCanvas canvas){
            MousePoint startPoint=new MousePoint(startMousePointX-4,startMousePointY-4);
            MousePoint endPoint=new MousePoint(startMousePointX+width+4,startMousePointY+height+4);
            Graphics2D graphics2d=canvas.getGraphics2D();
            Stroke stroke=new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,new float[]{10},0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawOval(startPoint.getXPoint(),startPoint.getYPoint(),Math.abs(startPoint.getXPoint()-endPoint.getXPoint()),Math.abs(startPoint.getYPoint()-endPoint.getYPoint()));
        }
    }
    public static class SelectRectOutline {
        public static void draw(int startMousePointX,int startMousePointY,int width,int height,PaintCanvas canvas){
            MousePoint startPoint=new MousePoint(startMousePointX-4,startMousePointY-4);
            MousePoint endPoint=new MousePoint(startMousePointX+width+4,startMousePointY+height+4);
            Graphics2D graphics2d=canvas.getGraphics2D();
            Stroke stroke=new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,new float[]{10},0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            graphics2d.drawRect(startPoint.getXPoint(),startPoint.getYPoint(),Math.abs(startPoint.getXPoint()-endPoint.getXPoint()),Math.abs(startPoint.getYPoint()-endPoint.getYPoint()));
        }
    }
    public static class SelectTriangleOutline {
        public static void draw(int xPoints[],int[] yPoints,PaintCanvas canvas){
            Graphics2D graphics2d=canvas.getGraphics2D();
            Stroke stroke=new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,new float[]{10},0);
            graphics2d.setStroke(stroke);
            graphics2d.setColor(Color.BLACK);
            
            int[] newXPoints={0,0,0},newYPoints={0,0,0};
           
    
            if (xPoints[0] < xPoints[2]) {
                newXPoints[0]=xPoints[0] - 4;
                newXPoints[1]=xPoints[1] - 4;
                newXPoints[2]=xPoints[2] + 8;
            } else {
                newXPoints[0]=xPoints[2] - 8;
                newXPoints[1]=xPoints[1] + 4;
                newXPoints[2]=xPoints[0] + 4;
            }
            if (yPoints[0] < yPoints[2]) {
                newYPoints[0]=yPoints[0] - 8;
                newYPoints[1]=yPoints[1] + 4;
                newYPoints[2]=yPoints[2] + 4;
            } else {
                newYPoints[0]=yPoints[2] - 4;
                newYPoints[1]=yPoints[1] - 4;
                newYPoints[2]=yPoints[0] + 8;
            }
               
           
            graphics2d.drawPolygon(newXPoints,newYPoints,3);
        }
    }
}
