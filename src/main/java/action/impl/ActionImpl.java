package action.impl;

import action.Action;
import enums.Directions;
import enums.Moves;
import enums.Spaces;
import explorer.Explorer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by chetan on 18.12.2017.
 */
public class ActionImpl implements Action {

    private Explorer explorer;

    public ActionImpl(Explorer explorer) {
        this.explorer = explorer;
    }


    @Override
    public void applyMove(Moves moves) {
        switch (moves) {
            case FORWARD: moveForward(); break;
            case LEFT: moveLeft();break;
            case RECORD: recordMoves(); break;
            case RIGHT: moveRight(); break;
            case FRONT: checkAtTheFront();break;
        }
    }

    private List<String> recordMoves() {
        AtomicInteger index = new AtomicInteger();
        explorer.getHistoryOfMoves().stream().forEach(m -> System.out.println(index.incrementAndGet() + " " + m));
        return explorer.getHistoryOfMoves();
    }

    private String checkAtTheFront() {
        Spaces spaces = checkWhatExistsToTheFront(explorer.getMaze().getMaze(), explorer.getCurrentDirection(), explorer.getCurrentPosition());
        System.out.println(spaces.getDescription());
        return spaces.getDescription();
    }

    private Directions moveRight() {
        Directions rightDirection = Directions.of(explorer.getCurrentDirection().getRightDirection());
        explorer.setCurrentDirection(rightDirection);
        explorer.getHistoryOfMoves().add(Moves.RIGHT.toString(explorer.getCurrentDirection()));

        return explorer.getCurrentDirection();
    }

    private Directions moveLeft() {
        Directions leftDirection = Directions.of(explorer.getCurrentDirection().getLeftDirection());
        explorer.setCurrentDirection(leftDirection);
        explorer.getHistoryOfMoves().add(Moves.LEFT.toString(explorer.getCurrentDirection()));

        return explorer.getCurrentDirection();
    }

    private Point moveForward() {
        int frontX = explorer.getCurrentPosition().x + explorer.getCurrentDirection().getDisplacementX();
        int frontY = explorer.getCurrentPosition().y + explorer.getCurrentDirection().getDispacementY();
        explorer.setCurrentPosition(new Point(frontX, frontY));
        explorer.getHistoryOfMoves().add(Moves.FORWARD.toString(explorer.getCurrentDirection()));

        return explorer.getCurrentPosition();
    }

    private Spaces checkWhatExistsToTheFront(String[][] mazeArray, Directions currentDirection, Point currentPosition) {
        try {
            int dx = currentDirection.getDisplacementX();
            int dy = currentDirection.getDispacementY();
            int frontX = currentPosition.x + dx;
            int frontY = currentPosition.y + dy;

            return Spaces.of(mazeArray[frontX][frontY]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return Spaces.of("B");
        }
    }

    public List<String> checkAvailableMoves(Directions currentDirection, Point currentPosition) {
        String[][] mazeArray = explorer.getMaze().getMaze();
        List<String> availableMoves = new ArrayList<>();
        availableMoves.add(Moves.LEFT.getHotkey() + "-" + Moves.LEFT.getDescription());
        availableMoves.add(Moves.RIGHT.getHotkey() + "-" + Moves.RIGHT.getDescription());
        availableMoves.add(Moves.RECORD.getHotkey() + "-" + Moves.RECORD.getDescription());
        availableMoves.add(Moves.FRONT.getHotkey() + "-" + Moves.FRONT.getDescription());
        Spaces spaces = checkWhatExistsToTheFront(mazeArray, currentDirection, currentPosition);
        if (!(spaces.equals(Spaces.WALL) || spaces.equals(Spaces.BOUNDARY))) {
            availableMoves.add(Moves.FORWARD.getHotkey() + "-" + Moves.FORWARD.getDescription());
        }

        return availableMoves;
    }

}
