package com.podgurskiy.xo;

import com.podgurskiy.xo.model.Field;
import com.podgurskiy.xo.model.Game;
import com.podgurskiy.xo.model.Player;
import com.podgurskiy.xo.view.ConsolView;

public class Main {

    public static void main(String[] args) {

        final ConsolView consolView = new ConsolView();

        final Field field = new Field(3);

        final Player[] players = consolView.createPlayers();

        final Game game = new Game("XO", players, field);

        consolView.show(game);

        while (consolView.move(game)) {
            consolView.show(game);
        }
    }
}
