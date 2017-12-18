package maze;

/**
 * Created by chetan on 17.12.2017.
 */
public interface MazeRelated {
    Integer getNoOfWalls();
    Integer getNoOfEmptySpaces();
    String getSpace(int x, int y);
}
