package com.podgurskiy.xo.controller;

import com.podgurskiy.xo.model.Field;
import com.podgurskiy.xo.model.Figure;
import com.podgurskiy.xo.model.exceptions.AlreadyOccupiedException;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Figure figure, final Point point)
            throws AlreadyOccupiedException, InvalidPointException {

        field.setFigure(point, figure);

    }
}
