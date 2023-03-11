package model;

import view.MousePoint;
import view.gui.PaintCanvas;
import javax.swing.JComponent;

import model.interfaces.IBaseShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

import java.awt.*;
import java.awt.geom.AffineTransform;;

public class DrawTriangle implements IShape {
    private MousePoint startMousePoint;
    private MousePoint endMousePoint;
    private Color primaryColor;
    private Color secondaryColor;
    private PaintCanvas canvas;
    private String shadeType;
    private int[] xPoints = new int[3];
    private int[] yPoints = new int[3];
    private double deg;
    Graphics2D graphics2d;
    public DrawTriangle(MousePoint startMousePoint, MousePoint endMousePoint, Color primaryColor, Color secondaryColor,
            String shadeType, PaintCanvas canvas) {
        this.startMousePoint = startMousePoint;
        this.endMousePoint = endMousePoint;
        this.primaryColor = primaryColor;
        this.canvas = canvas;
        this.shadeType = shadeType;
        this.secondaryColor = secondaryColor;
        xPoints[0] = startMousePoint.getXPoint();
        xPoints[1] = startMousePoint.getXPoint();
        xPoints[2] = endMousePoint.getXPoint();

        yPoints[0] = startMousePoint.getYPoint();
        yPoints[1] = endMousePoint.getYPoint();
        yPoints[2] = endMousePoint.getYPoint();

        deg=Math.toDegrees(0);
    }

    public void draw() {
         graphics2d = canvas.getGraphics2D();
        
        if (shadeType.equalsIgnoreCase("FILLED_IN")) {
            graphics2d.setColor(primaryColor);
            graphics2d.rotate(deg,(xPoints[0]+xPoints[1]+xPoints[2])/3,(yPoints[0]+yPoints[1]+yPoints[2])/3);
            graphics2d.fillPolygon(xPoints, yPoints, 3);
        } else if (shadeType.equalsIgnoreCase("OUTLINE")) {
            graphics2d.setStroke(new BasicStroke(4.0f));
            graphics2d.setColor(primaryColor);
            graphics2d.rotate(deg,(xPoints[0]+xPoints[1]+xPoints[2])/3,(yPoints[0]+yPoints[1]+yPoints[2])/3);
            graphics2d.drawPolygon(xPoints, yPoints, 3);
        } else if (shadeType.equalsIgnoreCase("OUTLINE_AND_FILLED_IN")) {
            graphics2d.setColor(primaryColor);
            graphics2d.fillPolygon(xPoints, yPoints, 3);
            graphics2d.setStroke(new BasicStroke(4.0f));
            graphics2d.setColor(secondaryColor);
            graphics2d.rotate(deg,(xPoints[0]+xPoints[1]+xPoints[2])/3,(yPoints[0]+yPoints[1]+yPoints[2])/3);
            graphics2d.drawPolygon(xPoints, yPoints, 3);
        }
    }

    @Override 
    public double getRotate(){
        return deg;
    }
    @Override
    public void undo() {
        ShapeHistoryList.shapeList.remove(this);
        canvas.refresh(canvas);

    }

    @Override
    public void redo() {
        ShapeHistoryList.shapeList.add(this);
        canvas.refresh(canvas);
    }

    public int[] getXPoints() {
        return xPoints;
    }
    public int[] getYPoints() {
        return yPoints;
    }
    @Override
    public int getStartPointX() {
        if(xPoints[0]<xPoints[2]){
            return xPoints[0];
        }
        else{
            return xPoints[2];
        }
    }
    @Override 
    public void rotate(double deg){
        this.deg=deg;
    }
    @Override
    public int getStartPointY() {

        if(yPoints[0]<yPoints[2]){
            return yPoints[0];
        }
        else{
            return yPoints[2];
        }
    }

    @Override
    public int getWidth() {

        return Math.abs(xPoints[0]-xPoints[2]);
    }

    @Override
    public int getHeight() {

        return Math.abs(yPoints[0]-yPoints[2]);
    }

    @Override
    public PaintCanvas getPaintCanvas() {

        return canvas;
    }

    @Override
    public MousePoint getStartPoint() {

        return startMousePoint;
    }

    @Override
    public MousePoint getEndPoint() {

        return endMousePoint;
    }

    @Override
    public IShape getIShape() {

        return getIShape();
    }

    @Override
    public void updatePoints(int xPoint, int yPoint) {
        xPoints[0]=xPoints[0]+xPoint;
        xPoints[1]=xPoints[1]+xPoint;
        xPoints[2]=xPoints[2]+xPoint;
        yPoints[0]=yPoints[0]+yPoint;
        yPoints[1]=yPoints[1]+yPoint;
        yPoints[2]=yPoints[2]+yPoint;
        
    }
    @Override
    public Color getPrimaryColor() {
       return primaryColor;
    }

    @Override
    public Color getSecondaryColor() {
       return secondaryColor;
    }

    @Override
    public String getShadeType() {
       return shadeType;
    }
}
