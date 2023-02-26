package model;

import view.MousePoint;
import view.gui.PaintCanvas;
import javax.swing.JComponent;

import model.interfaces.IBaseShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

import java.awt.*;

public class DrawRectangle implements IShape {
    private MousePoint startMousePoint;
    private MousePoint endMousePoint;
    private Color primaryColor;
    private Color secondaryColor;
    String shadeType;
    private PaintCanvas canvas;
    private int height;
    private int width;
    private int startX;
    private int startY;

    public DrawRectangle(MousePoint startMousePoint, MousePoint endMousePoint, Color primaryColor,Color secondaryColor, String shadeType,
            PaintCanvas canvas) {
        this.startMousePoint = startMousePoint;
        this.endMousePoint = endMousePoint;
        this.primaryColor = primaryColor;
        this.canvas = canvas;
        this.shadeType = shadeType;
        this.secondaryColor=secondaryColor;
        startX = Math.min(startMousePoint.getXPoint(), endMousePoint.getXPoint());
        startY = Math.min(startMousePoint.getYPoint(), endMousePoint.getYPoint());
        width = Math.abs(startMousePoint.getXPoint() - endMousePoint.getXPoint());
        height = Math.abs(startMousePoint.getYPoint() - endMousePoint.getYPoint());
    }

    public void draw() {
        Graphics2D graphics2d = canvas.getGraphics2D();
        if (shadeType.equalsIgnoreCase("FILLED_IN")) {
            graphics2d.setColor(primaryColor);
            graphics2d.fillRect(startX, startY, width, height);
        } else if (shadeType.equalsIgnoreCase("OUTLINE")) {
            graphics2d.setStroke(new BasicStroke(4.0f));
            graphics2d.setColor(primaryColor);
            graphics2d.drawRect(startX, startY, width, height);
        }else if(shadeType.equalsIgnoreCase("OUTLINE_AND_FILLED_IN")){
            graphics2d.setColor(primaryColor);
            graphics2d.fillRect(startX, startY, width, height);
            graphics2d.setStroke(new BasicStroke(4.0f));
            graphics2d.setColor(secondaryColor);
            graphics2d.drawRect(startX, startY, width, height); 
        }
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

    @Override
    public int getStartPointX() {

        return startX;
    }

    @Override
    public int getStartPointY() {

        return startY;
    }

    @Override
    public int getWidth() {

        return width;
    }

    @Override
    public int getHeight() {

        return height;
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
        startX+=xPoint;
        startY+=yPoint;
        
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
