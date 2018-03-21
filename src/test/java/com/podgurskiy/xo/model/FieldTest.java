package com.podgurskiy.xo.model;

import com.podgurskiy.xo.model.exceptions.AlreadyOccupiedException;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    private Field<Figure> field;

    final private int FIELD_SIZE = 3;

    private Point pointX;
    private Point pointO;
    private Point pointNull;
    private Point illegalPoint;

    @Before
    public void setUp() throws Exception {

        field = new Field<>(FIELD_SIZE);

        pointX = new Point(0, 0);
        pointO = new Point(2, 2);
        pointNull = new Point(1, 1);
        illegalPoint = new Point(-1, -1);

        field.setFigure(pointX, Figure.X);
        field.setFigure(pointO, Figure.O);
    }

    @Test
    public void getSize() {
        assertEquals(3, field.getSize());
    }

    @Test
    public void getFigureWhenFigureIsNull() {
        try {
            assertNull(field.getFigure(pointNull));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFigureWhenFigureX() {
        try {
            assertEquals(Figure.X, field.getFigure(pointX));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFigureWhenFigureO() {
        try {
            assertEquals(Figure.O, field.getFigure(pointO));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPointIsIllegal() {
        try {
            field.getFigure(illegalPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenCoordinateIsIllegal() throws AlreadyOccupiedException {
        try {
            field.setFigure(illegalPoint, Figure.X);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenFigureIsNotEmpty() throws AlreadyOccupiedException, InvalidPointException {

        try {
            field.setFigure(pointX, Figure.O);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }
}