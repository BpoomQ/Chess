/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pieces;

import game.Piece;
import game.PieceType;
import game.Position;
import game.Spot;

/**
 *
 * @author Luis Alejandro Tarazona
 */
public class Bishop extends Piece {

    public Bishop(String Color) {
        super(Color);
        type = PieceType.B;
    }

    @Override
    public boolean isValidPath(Position start, Position end, Spot[][] board) {
        if (Math.abs(end.getI() - start.getI()) == Math.abs(end.getJ() - start.getJ())) {
            if (start.getI() < end.getI() && start.getJ() < end.getJ()) {
                for (int i = start.getI() + 1, j = start.getJ() + 1;
                        i < end.getI() && j < end.getJ();
                        i++, j++) {

                    if (board[i][j].getPiece() != null) {
                        return false;
                    }
                }
            } else if (start.getI() < end.getI() && start.getJ() > end.getJ()) {
                for (int i = start.getI() + 1, j = start.getJ() - 1;
                        i < end.getI() && j > end.getJ();
                        i++, j--) {
                    if (board[i][j].getPiece() != null) {
                        return false;
                    }
                }
            } else if (start.getI() > end.getI() && start.getJ() < end.getJ()) {
                for (int i = start.getI() - 1, j = start.getJ() + 1;
                        i > end.getI() && j <end.getJ();
                        i--, j++) {
                    if (board[i][j].getPiece() != null) {
                        return false;
                    }
                }
            } else {
                for (int i = start.getI() - 1, j = start.getJ() - 1;
                        i > end.getI() && j > end.getJ();
                        i--, j--) {
                    if (board[i][j].getPiece() != null) {
                        return false;
                    }
                }
            }
            return board[end.getI()][end.getJ()].getPiece() != null
                    ? !board[end.getI()][end.getJ()].getPiece().color.equals(this.color)
                    : true;
        }
        return false;
    }

    @Override
    public PieceType getType() {
        return type;
    }

}
