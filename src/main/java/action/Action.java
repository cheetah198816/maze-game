package action;

import enums.Directions;
import enums.Moves;

import java.awt.*;
import java.util.List;

/**
 * Created by chetan on 18.12.2017.
 */
public interface Action {
    /**
     * applies a given move(Forward, Left, Right etc.)
     *
     * @param moves
     */
    void applyMove(Moves moves);

    /**
     * checks for the available moves for the user at the given position.
     *
     * @param currentDirection current direction of the user.
     * @param currentPosition  current position of the user.
     * @return list of available moves.
     */
    List<String> checkAvailableMoves(Directions currentDirection, Point currentPosition);
}
