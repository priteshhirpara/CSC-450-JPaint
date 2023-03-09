# JPaint
## MS-Paint Like application using JAVA


## **Sprint 1**
- can only draw filled rectangle with default blue color.
- can undo or redo the drawn rectangles.

## **Sprint 2**
- can draw filled,outlined,outlined and filled rectangle,oval and triangle with any selected primary and secondary color.
- can select/deselect any one or multiple shapes.
- can move any selected shapes and perform undo,redo on these movements.
- can undo or redo the drawn rectangles.

### **Sprint 3**
- selected shapes has dashed outline around it
- selected shapes can be copied and added to a clipboard list
- can paste selected shapes
- selected outline will be transferred to newly pasted shapes so that it can be easily moved or deleted
- can und/redo paste command
- can delete selected shapes
- can undo/redo delete command
- can group/ungroup multiple shapes.

## bugs
- when application is minimized and maximizied again all drawn shapes disappears.(but if we use undo/redo it comes back)

## **GirHub Repo**
- https://github.com/priteshhirpara/JPaint.git

## **design patterns**
1. MouseClickEvenHandler.java uses Singleton Pattern
2. CopyCommand.java,PasteCommand.java,SelectCommand.java,MoveCommand.java,DeleteCommand.java uses Command Pattern
3. DrawCommand.java uses Strategy Pattern
4. SelectedOutline.java, SelectedShapeOutline.java uses ProxyPattern
5. GroupedShapes.java uses CompositePattern