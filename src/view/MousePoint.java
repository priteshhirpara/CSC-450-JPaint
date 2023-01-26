package view;

public class MousePoint {
    private int x=0;
    private int y=0;
    public MousePoint(){

    }
    public MousePoint(int x,int y){
        this.x=x;
        this.y=y;
    }   
    public int getXPoint(){
        return x;
    } 
    public int getYPoint(){
        return y;
    }

}
