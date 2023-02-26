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
- selected shapes has dashed outline around it (just tried to implement and it worked!)

## **missing features/feature yet to be implemented**
- copy/paste, group/ungroup feature does not work yet.
- delete does not work

### all above mentioned features are not implemented yet, those are to be implemented in upcoming 2 sprints.

## bugs
- when application is minimized and maximizied again all drawn shapes disappears.(but if we use undo/redo it comes back)

## **GirHub Repo**
- https://github.com/priteshhirpara/JPaint.git

## **design patterns**
1. MouseClickEvenHandler.java uses Singleton Pattern
2. DrawCommand.java uses Command Pattern
3. DrawRect.java, DrawEllipse.java, DrawTriangle.java uses Strategy Pattern
4. SelectedOutline.java, SelectedShapeOutline.java uses ProxyPattern
