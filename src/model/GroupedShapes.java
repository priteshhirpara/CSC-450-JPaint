package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IGroupedShapeHistory;
import model.interfaces.IShape;

public class GroupedShapes {
 List<IShape> groupedShapes=new ArrayList<>();

 public void add(IShape shape){
    groupedShapes.add(shape);
 }
 public void remove(IShape shape){
    groupedShapes.remove(shape);
 }
 
 public List<IShape> getList(){
    return groupedShapes;
 } 

}
