package maze;

import java.awt.*;

/**
 * Created by chetan on 18.12.2017.
 */
public interface ExplorerRelated {

    /**
     * Fetches a maze.
     *
     * @return maze(2 dimensional array)
     */
    String[][] getMaze();

    /**
     * Gets the starting point of the maze.
     *
     * @return starting point co-ordinates.
     */
    Point getStartingPoint();
}
