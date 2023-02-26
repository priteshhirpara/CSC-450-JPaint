package model.interfaces;


import view.MousePoint;
import view.gui.PaintCanvas;
import java.awt.*;

public interface IShape extends IUndoable

{
    public int getStartPointX();
    public int getStartPointY();
    public int getWidth();
    public int getHeight();
    public PaintCanvas getPaintCanvas();
    public MousePoint getStartPoint();
    public MousePoint getEndPoint();
    public IShape getIShape();
    public void draw();
    public void updatePoints(int xPoint,int yPoint);
    public Color getPrimaryColor();   
    public Color getSecondaryColor();   
    public String getShadeType();
}
