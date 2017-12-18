package explorer;

import action.Action;
import action.impl.ActionImpl;
import enums.Directions;
import enums.Moves;
import maze.ExplorerRelated;
import maze.impl.MazeImpl;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


/**
 * Created by chetan on 17.12.2017.
 */
public class Explorer {

    private ExplorerRelated maze;

    private Directions currentDirection;

    private Point currentPosition;

    private List<String> historyOfMoves = new ArrayList<>();

    public Explorer(ExplorerRelated maze) {
        this.maze = maze;
        this.currentDirection = Directions.NORTH;
        this.currentPosition = maze.getStartingPoint();
        historyOfMoves.add("User is at starting position facing towards " + currentDirection.getDescription());
    }

    public void startExploration() {
        String[][] mazeArray = maze.getMaze();
        if (mazeArray != null) {
            while (!mazeArray[currentPosition.x][currentPosition.y].equals("F")) {
                Action action = new ActionImpl(this);
                System.out.println("Please select the explorer movements :");
                List<String> availableMoves = action.checkAvailableMoves(currentDirection, currentPosition);
                availableMoves.stream().forEach(m -> System.out.println(m));
                Scanner scanner = new Scanner(System.in);
                String hotKey = scanner.nextLine();
                Optional<Moves> moves = Moves.of(hotKey);
                if (moves.isPresent()) {
                    action.applyMove(moves.get());
                }

            }
            System.out.println("Exploration Complete");
        } else {
            System.out.println("Maze not Loaded.");
        }
    }

    public ExplorerRelated getMaze() {
        return maze;
    }

    public Directions getCurrentDirection() {
        return currentDirection;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public List<String> getHistoryOfMoves() {
        return historyOfMoves;
    }

    public void setCurrentDirection(Directions currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public static void main(String[] args) {
        ExplorerRelated maze = new MazeImpl("Maze.txt");
        Explorer explorer = new Explorer(maze);
        explorer.startExploration();
    }

}
