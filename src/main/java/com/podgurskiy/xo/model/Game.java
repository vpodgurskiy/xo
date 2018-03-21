package com.podgurskiy.xo.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Game<T> implements Iterable<Player> {

    private final String name;

    private final Player[] players;

    private final Field<T> field;

    public Game(final String name, final Player[] players, final Field<T> field) {

        this.name = name;
        this.players = players;
        this.field = field;

    }

    public final Player[] getPlayers() {

        return players;

    }

    public final Field<T> getField() {

        return field;

    }

    public final String getName() {

        return name;

    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > current;
        }

        @Override
        public Player next() {
            if (!hasNext()) throw new NoSuchElementException();
            return Game.this.players[current++];
        }
    }
}
