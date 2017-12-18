package enums;

import java.util.Arrays;

/**
 * Created by chetan on 17.12.2017.
 */
public enum Spaces {
    WALL("X", "A wall exists"),
    EMPTY_SPACE(" ", "A empty space exists"),
    STARTING_POINT("S", "Its a starting point."),
    FINISH_POINT("F", "Its a finish point."),
    BOUNDARY("B", "Its out of boundary");

    private String space;
    private String description;

    Spaces(String space , String description) {
        this.space = space;
        this.description = description;
    }

    public static Spaces of(String space) {
        return Arrays.stream(values()).filter(s -> s.getSpace().equals(space)).findAny().get();
    }

    public String getDescription() {
        return description;
    }

    public String getSpace() {
        return space;
    }
}
