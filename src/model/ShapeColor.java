package model;
import java.awt.*;
import java.util.EnumMap;
public enum ShapeColor {
    BLACK,
    BLUE,
    CYAN,
    DARK_GRAY,
    GRAY,
    GREEN,
    LIGHT_GRAY,
    MAGENTA,
    ORANGE,
    PINK,
    RED,
    WHITE,
    YELLOW;
    public static EnumMap<ShapeColor,Color> colors=new EnumMap<>(ShapeColor.class);
    public static void setup(){
        colors.put(BLACK, Color.BLACK);
        colors.put(BLUE, Color.BLUE);
        colors.put(CYAN, Color.CYAN);
        colors.put(DARK_GRAY, Color.DARK_GRAY);
        colors.put(GRAY, Color.GRAY);
        colors.put(GREEN, Color.GREEN);
        colors.put(LIGHT_GRAY, Color.LIGHT_GRAY);
        colors.put(MAGENTA, Color.MAGENTA);
        colors.put(ORANGE, Color.ORANGE);
        colors.put(PINK, Color.PINK);
        colors.put(RED, Color.RED);
        colors.put(WHITE, Color.WHITE);
        colors.put(YELLOW, Color.YELLOW);
    }
    public static EnumMap getMap(){
        setup();
        return colors;
    }
}


