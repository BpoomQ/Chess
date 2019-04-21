/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.pieces.Bishop;
import game.pieces.Knight;
import game.pieces.Pawn;
import java.util.ArrayList;

/**
 *
 * @author Luis Alejandro Tarazona
 */
public class Board {

    private final Spot board[][];
    private final ArrayList<Piece> pieces;

    public Board() {
        board = new Spot[8][8];
        pieces = new ArrayList<>();
        for (Spot[] board1 : board) {
            for (int j = 0; j < board1.length; j++) {
                board1[j] = new Spot();
            }
        }
        initalizeBoard();
    }

    private void initalizeBoard() {
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void initializeBlackPieces() {
        String color = "b";
        board[0][1].insertPiece(new Knight(color));
        board[0][2].insertPiece(new Bishop(color));
        board[0][5].insertPiece(new Bishop(color));
        board[0][6].insertPiece(new Knight(color));
        for (int i = 0; i < board.length; i++) {
            board[1][i].insertPiece(new Pawn(color));
        }
    }

    private void initializeWhitePieces() {
        String color = "w";
        board[7][1].insertPiece(new Knight(color));
        board[7][2].insertPiece(new Bishop(color));
        board[7][5].insertPiece(new Bishop(color));
        board[7][6].insertPiece(new Knight(color));
        for (int i = 0; i < board.length; i++) {
            board[6][i].insertPiece(new Pawn(color));
        }
    }

    public boolean isTherePiece(String playerColor, Position position) {
        return !board[position.getI()][position.getJ()].isAvailabe()
                && board[position.getI()][position.getJ()].getPiece().color.equals(playerColor);
    }

    @Override
    public String toString() {
        char alphabet[] = new char[board.length];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        String boardString = "";
        for (int i = 0, k = 8; i < board.length; i++, k--) {
            boardString += k + " ";
            for (Spot item : board[i]) {
                boardString += item.isAvailabe() ? "[  ]" : "[" + item + item.getPiece().color + "]";
            }
            boardString += i < board.length - 1 ? "\n" : "";
        }
        boardString += "\n ";
        for (int i = 0; i < board.length; i++) {
            boardString += "   " + alphabet[i];
        }
        return boardString;
    }
}
