package com.podgurskiy.xo.view;

import com.podgurskiy.xo.controller.CurrentMoveController;
import com.podgurskiy.xo.controller.MoveController;
import com.podgurskiy.xo.controller.WinnerController;
import com.podgurskiy.xo.model.Field;
import com.podgurskiy.xo.model.Figure;
import com.podgurskiy.xo.model.Game;
import com.podgurskiy.xo.model.Player;
import com.podgurskiy.xo.model.exceptions.AlreadyOccupiedException;
import com.podgurskiy.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolView {

    public final void show(final Game<Figure> game) {

        final Field<Figure> field = game.getField();

        System.out.format("Game name: %s\n", game.getName());

        showPlayers(game);

        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                printSeparator();
            }
            printLine(field, i);
        }
    }

    public boolean move(final Game<Figure> game) {

        final Field<Figure> field = game.getField();

        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final WinnerController winnerController = new WinnerController();

        final MoveController moveController = new MoveController();

        Figure winnerFigure = winnerController.getWinner(field);
        if (winnerFigure != null) {
            System.out.format("The winner is: %s\n", winnerFigure);
            return false;
        }

        Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("Now winner");
            return false;
        }

        System.out.format("Please input point for %s\n", currentFigure);
        final Point point = askPoint();

        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (final AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid!");
        }
        return true;

    }

    public final Player[] createPlayers() {

        final Player player1 = new Player(inputPlayerName(Figure.X), Figure.X);

        final Player player2 = new Player(inputPlayerName(Figure.O), Figure.O);

        final Player[] players = {player1, player2};

        return players;

    }

    private void showPlayers(final Game<Figure> game) {
        System.out.println("Players:");
        for (Player player : game) {
            System.out.format("Player name %s, figure %s\n", player.getName(), player.getFigure());
        }
    }

    private String inputPlayerName(final Figure figure) {

        System.out.format("Input figure %s player's name : ", figure);
        final Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private Point askPoint() {
        return new Point(askCoordinate("x"), askCoordinate("y"));
    }

    private int askCoordinate(final String coordinate) {
        System.out.format("Please input coordinate %s :_", coordinate);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        }catch (final InputMismatchException e) {
            return askCoordinate(coordinate);
        }
    }

    private void printLine(final Field<Figure> field, final int i) {

        for (int j = 0; j < field.getSize(); j++) {
            if (j != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(i, j));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("-----------");
    }
}
