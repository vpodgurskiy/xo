package com.podgurskiy.xo.controller;

import com.podgurskiy.xo.model.Field;
import com.podgurskiy.xo.model.Figure;
import com.podgurskiy.xo.model.exceptions.AlreadyOccupiedException;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    private Field<Figure> field;

    private WinnerController winnerController;

    private final int FIELD_SIZE = 3;

    @Before
    public void setUp() throws Exception {

        field = new Field<Figure>(FIELD_SIZE);

        winnerController = new WinnerController();

    }

    @Test
    public void getWinnerWhenWinnerXInTheRow() throws AlreadyOccupiedException, InvalidPointException {

        for (int i = 0; i < FIELD_SIZE; i++) {
            field.setFigure(new Point(0, i), Figure.X);
        }

        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);

        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(Figure.X, actualValue);

    }

    @Test
    public void getWinnerWhenWinnerXInTheColumn() throws AlreadyOccupiedException, InvalidPointException {

        for (int i = 0; i < FIELD_SIZE; i++) {
            field.setFigure(new Point(i, 0), Figure.X);
        }

        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);

        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(Figure.X, actualValue);

    }

    @Test
    public void getWinnerWhenWinnerXInTheDiagonal() throws AlreadyOccupiedException, InvalidPointException {

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);

        field.setFigure(new Point(1, 0), Figure.O);
        field.setFigure(new Point(2, 1), Figure.O);

        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(Figure.X, actualValue);
    }

    @Test
    public void getWinnerWhenNoWinner() throws AlreadyOccupiedException, InvalidPointException {

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 2), Figure.X);

        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);

        final Figure actualValue = winnerController.getWinner(field);

        assertNull(actualValue);
    }
}