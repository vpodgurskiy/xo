package com.podgurskiy.xo.controller;

import com.podgurskiy.xo.model.Field;
import com.podgurskiy.xo.model.Figure;
import com.podgurskiy.xo.model.exceptions.AlreadyOccupiedException;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    private Field<Figure> field;

    private CurrentMoveController currentMoveController;

    private final int FIELD_SIZE = 3;


    @Before
    public void setUp() throws Exception {

        field = new Field<>(FIELD_SIZE);

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);

        currentMoveController = new CurrentMoveController();
    }

    @Test
    public void currentMoveWhenXMove() throws AlreadyOccupiedException, InvalidPointException {

        final Figure actualValue = currentMoveController.currentMove(field);

        assertEquals(Figure.X, actualValue);
    }

    @Test
    public void currentMoveWhenOMove() throws AlreadyOccupiedException, InvalidPointException {

        field.setFigure(new Point(0, 2), Figure.X);

        final Figure actualValue = currentMoveController.currentMove(field);

        assertEquals(Figure.O, actualValue);
    }

    @Test
    public void currentMoveWhenNoBodyMove() throws AlreadyOccupiedException, InvalidPointException {

        field.setFigure(new Point(2, 2), Figure.O);
        field.setFigure(new Point(0, 1), Figure.X);

        final Figure actualValue = currentMoveController.currentMove(field);

        assertEquals(Figure.X, actualValue);
    }
}