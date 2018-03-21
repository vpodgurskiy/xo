package com.podgurskiy.xo.model;

import com.podgurskiy.xo.model.exceptions.AlreadyOccupiedException;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field <T>{

    private static final int MIN_COORDINATE = 0;

    private final int MAX_COORDINATE;

    private final T[][] field;

    public Field(final int FIELD_SIZE) {
        this.MAX_COORDINATE = FIELD_SIZE;
        this.field = (T[][]) new Object[FIELD_SIZE][FIELD_SIZE];
    }

    public int getSize() {
        return field.length;
    }

    public T getFigure(final Point point) throws InvalidPointException {

        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final T figure) throws InvalidPointException,
            AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        if (getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }



}
