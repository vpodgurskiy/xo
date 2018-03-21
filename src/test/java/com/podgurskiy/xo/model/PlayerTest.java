package com.podgurskiy.xo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    public Player player;
    final String name = "Vadim";
    final Figure figure = Figure.X;

    @Before
    public void setUp() throws Exception {
        player = new Player(name, figure);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Vadim", player.getName());
    }

    @Test
    public void getFigure() {
        assertEquals(figure, player.getFigure());
    }
}