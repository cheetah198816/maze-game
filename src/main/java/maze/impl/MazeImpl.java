package maze.impl;

import enums.Spaces;
import maze.ExplorerRelated;
import maze.MazeRelated;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chetan on 17.12.2017.
 */
public class MazeImpl implements MazeRelated, ExplorerRelated {

    private String[][] maze;

    private Point startingPoint;

    private int noOfWalls;

    private int noOfEmptySpaces;

    public MazeImpl(String fileName) {
        loadMaze(fileName);
    }

    private String[][] loadMaze(String filename) {
        File file = new File("src/" + filename);
        List<String> rows = new ArrayList<>();
        AtomicInteger rowIndex = new AtomicInteger();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                rows.add(row);
            }
            maze = new String[rows.size()][rows.get(0).length()];
            rows.stream().forEach(r -> addRowInMaze(r, rowIndex));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return maze;
    }

    private void addRowInMaze(String row, AtomicInteger rowIndex) {
        String[] columnArray = row.split("");
        AtomicInteger columnIndex = new AtomicInteger();
        Arrays.stream(columnArray).forEach(c -> addToMaze(rowIndex, c, columnIndex));
        rowIndex.getAndIncrement();
    }

    private void addToMaze(AtomicInteger rowIndex, String character, AtomicInteger columnIndex) {
        final Spaces spaces = Spaces.of(character);
        switch (spaces) {
            case EMPTY_SPACE:
                noOfEmptySpaces++;
                break;
            case WALL:
                noOfWalls++;
                break;
            case STARTING_POINT:
                startingPoint = new Point(rowIndex.get(), columnIndex.get());
                break;
        }
        maze[rowIndex.get()][columnIndex.getAndIncrement()] = character;
    }

    @Override
    public Integer getNoOfWalls() {
        return noOfWalls;
    }

    @Override
    public Integer getNoOfEmptySpaces() {
        return noOfEmptySpaces;
    }

    @Override
    public String getSpace(int x, int y) {
        try {
            String description = Spaces.of(maze[x][y]).getDescription();
            return description;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return Spaces.of("B").getDescription();
        }
    }

    public String[][] getMaze() {
        return maze;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }
}
