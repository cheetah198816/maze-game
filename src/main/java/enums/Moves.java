package enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by chetan on 17.12.2017.
 */
public enum Moves {
    FORWARD(1, "f", "Move Forward"),
    LEFT(2, "l", "Turn Left"),
    RIGHT(3, "r", "Turn Right"),
    RECORD(4, "v", "Records of the visit"),
    FRONT(5, "d", "Check out whats at the front");

    private int id;
    private String hotkey;
    private String description;

    Moves(int id, String hotkey, String description) {
     this.id = id;
     this.description = description;
     this.hotkey = hotkey;
    }

    public static Optional<Moves> of(String hotKey) {
        return Arrays.stream(values()).filter(m -> m.getHotkey().equals(hotKey)).findAny();
    }

    public String getHotkey() {
        return hotkey;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String toString(Directions directions) {
        return "Explorer " + this.getDescription() + " towards " + directions.getDescription() + " Direction";
    }
}
