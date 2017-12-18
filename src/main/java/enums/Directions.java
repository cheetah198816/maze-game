package enums;

import java.util.Arrays;

/**
 * Created by chetan on 17.12.2017.
 */
public enum Directions {
    NORTH(-1, 0, "North", "West", "East"),
    SOUTH(1, 0, "South", "East", "West"),
    EAST(0, 1, "East", "North", "South"),
    WEST(0, -1, "West", "South", "North");

    private int displacementX;
    private int dispacementY;
    private String description;
    private String leftDirection;
    private String rightDirection;

    Directions(int displacementX, int dispacementY, String description, String leftDirection, String rightDirection) {
        this.displacementX = displacementX;
        this.dispacementY = dispacementY;
        this.description = description;
        this.leftDirection = leftDirection;
        this.rightDirection = rightDirection;
    }

    public static Directions of(String direction) {
        return Arrays.stream(values()).filter(d -> d.getDescription().equals(direction)).findAny().get();
    }

    public String getDescription() {
        return description;
    }

    public String getLeftDirection() {
        return leftDirection;
    }

    public String getRightDirection() {
        return rightDirection;
    }

    public int getDisplacementX() {
        return displacementX;
    }

    public int getDispacementY() {
        return dispacementY;
    }
}
