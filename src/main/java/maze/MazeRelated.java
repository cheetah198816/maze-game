package maze;

/**
 * Created by chetan on 17.12.2017.
 */
public interface MazeRelated {

    /**
     * Gets number of walls in the maze.
     *
     * @return number of walls.
     */
    Integer getNoOfWalls();

    /**
     * Gets number of empty spaces in the maze.
     *
     * @return number of empty spaces.
     */
    Integer getNoOfEmptySpaces();

    /**
     * Gets what exists at the given loction.
     *
     * @param x x co-ordinate of the given location.
     * @param y y co-ordinate of the given location.
     * @return A description of the space whether wall, empty space, boundary etc.
     */
    String getSpace(int x, int y);
}
