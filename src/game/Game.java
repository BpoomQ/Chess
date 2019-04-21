/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Luis Alejandro Tarazona
 */
public class Game {

    private Board board;
    private Player white;
    private Player black;
    private int turn;
    private final HashMap columnValues;
    private final HashMap rowValues;

    public Game() {
        br = new BufferedReader(new InputStreamReader(System.in));
        sc = new Scanner(System.in);
        columnValues = new HashMap();
        rowValues = new HashMap();
        for (int i = 0, j = 8; i < 8; i++, j--) {
            columnValues.put((char) ('a' + i), i);
            rowValues.put(Integer.toString(j).charAt(0), i);
        }
    }

    private final BufferedReader br;
    private final Scanner sc;

    public static void main(String[] args) throws IOException {
        Game chess = new Game();
        chess.run();
    }

    private void run() throws IOException {
        initPlayers();
        System.out.println(showGame());
        while (true) {
            playTurn();
        }
    }

    private void initPlayers() throws IOException {
        Player players[] = new Player[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ":");
            players[i] = new Player(br.readLine(), i % 2 == 0 ? "w" : "b");
        }
        this.white = players[0];
        this.black = players[1];
        initializeGame();
    }

    public void initializeGame() {
        if (white != null || black != null) {
            turn = 1;
            this.board = new Board();
        }
    }

    private void playTurn() throws IOException {
        Position start, end;
        System.out.println("Es el turno #" + turn
                + " juega: " + (turn % 2 != 0
                        ? white + " con las fichas blancas(w)"
                        : black + " con las fichas negras(b)"));
        start = startPosition();
        turn++;
    }

    public Position startPosition() throws IOException {
        Position start;
        String str[];
        do {
            System.out.println("Escoge la ficha que desea mover: (ej: a1)");
            str = br.readLine().split("");
            start = getPosition(str[0].charAt(0), str[1].charAt(0));
        } while (start == null
                || !board.isTherePiece(
                        turn % 2 != 0
                                ? white.getColor()
                                : black.getColor(),
                        start));
        return start;
    }

    public Position endPosition(Position start) throws IOException {
        Position end;
        String str[];
        do {
            System.out.println("Escoja a donde movera la ficha: (ej: a1)");
            str = br.readLine().split("");
            end = getPosition(str[0].charAt(0), str[1].charAt(0));
        } while (end == null
                || end.equals(start));
        return end;
    }

    public String showGame() {
        return "K = Knight(caballo) B = Bishop(Alfíl) P = Pawn(Peón)\n"
                + "w = white(blanco)\tb = black(negro)\n"
                + "\tPlayer 2: " + black + "\n"
                + board + "\n"
                + "\tPlayer 1: " + white;
    }

    private Position getPosition(char column, char row) {
        if (columnValues.containsKey(column) && (rowValues.containsKey(row))) {
            return new Position((int) rowValues.get(row), (int) columnValues.get(column));
        }
        return null;
    }
}
