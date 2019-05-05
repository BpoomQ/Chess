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
    private final ArrayList<Piece> deadWhitePieces;
    private final ArrayList<Piece> deadBlackPieces;
    private int whitePieces;
    private int blackPieces;

    public Board() {
        board = new Spot[8][8];
        deadWhitePieces = new ArrayList<>(8);
        deadBlackPieces = new ArrayList<>(8);
        whitePieces = 0;
        blackPieces = 0;
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
        blackPieces += 4;
        for (int i = 0; i < board.length; i++) {
            board[1][i].insertPiece(new Pawn(color));
            blackPieces++;
        }
    }

    private void initializeWhitePieces() {
        String color = "w";
        board[7][1].insertPiece(new Knight(color));
        board[7][2].insertPiece(new Bishop(color));
        board[7][5].insertPiece(new Bishop(color));
        board[7][6].insertPiece(new Knight(color));
        whitePieces += 4;
        for (int i = 0; i < board.length; i++) {
            board[6][i].insertPiece(new Pawn(color));
            whitePieces++;
        }
    }

    public boolean isTherePiece(String playerColor, Position position) {
        return !board[position.getI()][position.getJ()].isAvailabe()
                && board[position.getI()][position.getJ()].getPiece().color.equals(playerColor);
    }

    public Piece pickPiece(String playerColor, Position position) {
        return isTherePiece(playerColor, position)
                ? board[position.getI()][position.getJ()].getPiece()
                : null;
    }

    public Piece getPiece(Position position) {
        return board[position.getI()][position.getJ()].getPiece();
    }

    public boolean movePiece(Position start, Position end) {
        Piece piece = board[start.getI()][start.getJ()].getPiece();
        if (piece.isValidPath(start, end, board)) {
            if (!board[end.getI()][end.getJ()].isAvailabe()) {
                Piece temp = board[end.getI()][end.getJ()].getPiece();
                if (piece.color.equals(temp.color)) {
                    return false;
                }
                if (temp.color.equals("b")) {
                    deadBlackPieces.add(temp);
                } else {
                    deadWhitePieces.add(temp);
                }
                board[end.getI()][end.getJ()] = new Spot();
            }
            board[start.getI()][start.getJ()] = new Spot();
            board[end.getI()][end.getJ()].insertPiece(piece);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        char alphabet[] = new char[board.length];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        String boardString = "fichas blancas eliminadas: " + deadWhitePieces + "\n";
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
        return boardString + "\n fichas negras eliminadas: " + deadBlackPieces;
    }

    boolean isGameOver() {
        return (deadWhitePieces.size() == whitePieces) || (deadBlackPieces.size() == blackPieces);
    }
}
