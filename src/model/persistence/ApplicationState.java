package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.commands.AnimationCommand;
import model.commands.CopyCommand;
import model.commands.CurrentMouseMode;
import model.commands.DeleteCommand;
import model.commands.GroupCommand;
import model.commands.PasteCommand;
import model.commands.RedoCommand;
import model.commands.RotateCommand;
import model.commands.UnGroupCommand;
import model.commands.UndoCommand;
import model.MouseMode;
import model.SelectedOutline;
import model.SelectedShapeOutline;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }
    @Override
    public void undo(){
        UndoCommand undoCommand=new UndoCommand();
        undoCommand.run();
        if(UndoCommand.isUndoOptionSelected()){
            SelectedOutline undoOutline=new SelectedOutline(undoCommand);
            CurrentMouseMode.showOutline(undoOutline);   
        }
    }
    @Override
    public void redo(){
        RedoCommand redoCommand=new RedoCommand();
        redoCommand.run();
        if(RedoCommand.isRedoOptionSelected()){
            SelectedOutline redoOutline=new SelectedOutline(redoCommand);
            CurrentMouseMode.showOutline(redoOutline);   
        }
    }

    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }

    @Override
    public void copy() {
        new CopyCommand().run();
    }

    @Override
    public void paste() {
        new PasteCommand().run();
    }
    @Override
    public void delete() {
        new DeleteCommand().run();
    }
    @Override
    public void group() {
        new GroupCommand().run();
    }
    @Override
    public void ungroup() {
        new UnGroupCommand().run();
    }
    @Override
    public void rotate(){
        new RotateCommand().run();
    }
    @Override
    public void anim(){
        new AnimationCommand().run();
    }
   
}
