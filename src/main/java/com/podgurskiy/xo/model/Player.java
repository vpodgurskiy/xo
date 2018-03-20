package com.podgurskiy.xo.model;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public final String getName() {

        return name;
    }

    public final Figure getFigure() {

        return figure;
    }
}
