package model.interfaces;

import java.util.LinkedList;

import model.ShapeColor;
import view.MousePoint;
import view.gui.PaintCanvas;

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
    
}
