import action.Action;
import action.impl.ActionImpl;
import enums.Directions;
import explorer.Explorer;
import maze.ExplorerRelated;
import maze.impl.MazeImpl;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by chetan on 18.12.2017.
 */
public class ExplorerTest {

    public ExplorerRelated maze;

    public Explorer explorer;

    @Before
    public void init() {
        maze = new MazeImpl("testMaze/Maze.txt");
        explorer = new Explorer(maze);
    }

    @Test
    public void check_available_moves_test_when_wall_exists_at_the_front() {
        explorer.setCurrentPosition(new Point(3, 5));
        explorer.setCurrentDirection(Directions.NORTH);
        Action action = new ActionImpl(explorer);
        List<String> availableMoves = action.checkAvailableMoves(explorer.getCurrentDirection(), explorer.getCurrentPosition());

        assertThat(availableMoves.size()).isEqualTo(4);
    }

    @Test
    public void check_available_moves_test_when_boundary_exists_at_the_front() {
        explorer.setCurrentPosition(new Point(3, 14));
        explorer.setCurrentDirection(Directions.EAST);
        ActionImpl action = new ActionImpl(explorer);
        List<String> availableMoves = action.checkAvailableMoves(explorer.getCurrentDirection(), explorer.getCurrentPosition());

        assertThat(availableMoves.size()).isEqualTo(4);
    }

    @Test
    public void check_available_moves_test_when_empty_space_at_the_front() {
        explorer.setCurrentPosition(new Point(3, 13));
        explorer.setCurrentDirection(Directions.EAST);
        Action action = new ActionImpl(explorer);
        List<String> availableMoves = action.checkAvailableMoves(explorer.getCurrentDirection(), explorer.getCurrentPosition());

        assertThat(availableMoves.size()).isEqualTo(5);
    }

    @Test
    public void check_explorer_forward() {
        explorer.setCurrentPosition(new Point(3, 13));
        explorer.setCurrentDirection(Directions.EAST);
        ActionImpl action = new ActionImpl(explorer);
        Point point = action.moveForward();
        assertThat(point.x).isEqualTo(3);
        assertThat(point.y).isEqualTo(14);
    }

    @Test
    public void check_explorer_turn_left() {
        explorer.setCurrentDirection(Directions.EAST);
        ActionImpl action = new ActionImpl(explorer);
        Directions directions = action.moveLeft();

        assertThat(directions).isEqualTo(Directions.NORTH);
    }

    @Test
    public void check_explorer_turn_right() {
        explorer.setCurrentDirection(Directions.EAST);
        ActionImpl action = new ActionImpl(explorer);
        Directions directions = action.moveRight();

        assertThat(directions).isEqualTo(Directions.SOUTH);
    }

    @Test
    public void test_explorer_front_is_wall() {
        explorer.setCurrentDirection(Directions.NORTH);
        explorer.setCurrentPosition(new Point(3, 3));
        ActionImpl action = new ActionImpl(explorer);
        String description = action.checkAtTheFront();

        assertThat(description).isEqualTo("A wall exists");
    }

    @Test
    public void test_explorer_front_is_empty_space() {
        explorer.setCurrentDirection(Directions.EAST);
        explorer.setCurrentPosition(new Point(3, 3));
        ActionImpl action = new ActionImpl(explorer);
        String description = action.checkAtTheFront();

        assertThat(description).isEqualTo("A empty space exists");
    }

    @Test
    public void test_explorer_front_boundary() {
        explorer.setCurrentDirection(Directions.EAST);
        explorer.setCurrentPosition(new Point(3, 14));
        ActionImpl action = new ActionImpl(explorer);
        String description = action.checkAtTheFront();

        assertThat(description).isEqualTo("Its out of boundary");
    }

    @Test
    public void test_explorer_front_finish_point() {
        explorer.setCurrentDirection(Directions.SOUTH);
        explorer.setCurrentPosition(new Point(13, 1));
        ActionImpl action = new ActionImpl(explorer);
        String description = action.checkAtTheFront();

        assertThat(description).isEqualTo("Its a finish point.");
    }
}
