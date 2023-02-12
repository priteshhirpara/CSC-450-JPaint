package model;

import java.awt.*;


import view.gui.PaintCanvas;

public class SelectTriangleOutline {
    public void draw(int xPoints[],int[] yPoints,PaintCanvas canvas){
        Graphics2D graphics2d=canvas.getGraphics2D();
        Stroke stroke=new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,new float[]{10},0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        int[] tempx={0,0,0};
        int[] tempy={0,0,0};
        if(xPoints[0]<xPoints[2]){
            tempx[0]=xPoints[0]-4;
            tempx[1]=xPoints[1]-4;
            tempx[2]=xPoints[2]+8;
        }else{
            tempx[0]=xPoints[0]-8;
            tempx[1]=xPoints[1]+4;
            tempx[2]=xPoints[2]+4;
        }
        if(yPoints[0]<yPoints[2]){
            tempy[0]=yPoints[0]-4;
            tempy[1]=yPoints[1]-4;
            tempy[2]=yPoints[2]+8;
        }else{
            tempy[0]=yPoints[0]-8;
            tempy[1]=yPoints[1]+4;
            tempy[2]=yPoints[2]+4;
        }
        graphics2d.drawPolygon(tempx,tempy,3);
    }
}
