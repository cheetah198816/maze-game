import maze.ExplorerRelated;
import maze.MazeRelated;
import maze.impl.MazeImpl;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by chetan on 17.12.2017.
 */
public class CreateMazeTest {

    @Test
    public void create_maze_test_file_exists() {
        ExplorerRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");
        String[][] maze = mazeRelated.getMaze();

        assertThat(maze).isNotNull();
    }

    @Test
    public void create_maze_test_file_does_not_exists() {
        ExplorerRelated mazeRelated = new MazeImpl("testMaze/Maze1.txt");
        String[][] maze = mazeRelated.getMaze();

        assertThat(maze).isNull();
    }

    @Test
    public void total_empty_spaces_test() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");

        assertThat(mazeRelated.getNoOfEmptySpaces()).isEqualTo(76);
    }

    @Test
    public void total_walls_test() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");

        assertThat(mazeRelated.getNoOfWalls()).isEqualTo(147);
    }

    @Test
    public void get_space_test_walls_exists() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");
        String description = mazeRelated.getSpace(0, 0);

        assertThat(description).isEqualTo("A wall exists");
    }

    @Test
    public void get_space_test_empty_space_exists() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");
        String description = mazeRelated.getSpace(1, 1);

        assertThat(description).isEqualTo("A empty space exists");
    }

    @Test
    public void get_space_test_starting_point_exists() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");
        String description = mazeRelated.getSpace(3, 3);

        assertThat(description).isEqualTo("Its a starting point.");
    }

    @Test
    public void get_space_test_out_of_boundary() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");
        String description = mazeRelated.getSpace(16, 1);

        assertThat(description).isEqualTo("Its out of boundary");
    }

    @Test
    public void get_space_test_finish_point() {
        MazeRelated mazeRelated = new MazeImpl("testMaze/Maze.txt");
        String description = mazeRelated.getSpace(14, 1);

        assertThat(description).isEqualTo("Its a finish point.");
    }
}
