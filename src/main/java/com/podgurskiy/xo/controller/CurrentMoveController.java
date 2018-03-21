package com.podgurskiy.xo.controller;

import com.podgurskiy.xo.model.Field;
import com.podgurskiy.xo.model.Figure;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public final Figure currentMove(final Field field) {

        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            countFigure += countFiguresInRow(field, i);
        }

        if (countFigure == field.getSize() * field.getSize()) {
            return null;
        }

        if (countFigure % 2 == 0) {
            return Figure.X;
        }

        return Figure.O;
    }

    private int countFiguresInRow(final Field field, final int row) {

        int countFigure = 0;

        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null) {
                    countFigure++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        return countFigure;
    }



}
