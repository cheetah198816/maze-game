package action;

import enums.Directions;
import enums.Moves;

import java.awt.*;
import java.util.List;

/**
 * Created by chetan on 18.12.2017.
 */
public interface Action {
    void applyMove(Moves moves);
    List<String> checkAvailableMoves(Directions currentDirection, Point currentPosition);
}
