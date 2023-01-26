package model;

import model.interfaces.IShape;

public class ShapeHistory {
    private IShape drawShape;

    public ShapeHistory(IShape drawShape) {
        this.drawShape = drawShape;
    }
    public void draw(){
        drawShape.draw();
    }
    public IShape getShape(){
        return drawShape;
    }
}
