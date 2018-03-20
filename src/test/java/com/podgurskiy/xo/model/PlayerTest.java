package com.podgurskiy.xo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    public Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("Vadim", Figure.X);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Vadim", player.getName());
    }

    @Test
    public void getFigure() {
    }
}