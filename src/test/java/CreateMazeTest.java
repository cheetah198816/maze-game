import explorer.Explorer;
import maze.ExplorerRelated;
import maze.impl.MazeImpl;
import org.junit.Test;

/**
 * Created by chetan on 17.12.2017.
 */
public class CreateMazeTest {

    @Test
    public void create_maze_test() {
        ExplorerRelated maze = new MazeImpl("Maze.txt");
        Explorer explorer = new Explorer(maze);
        explorer.startExploration();
    }
}
