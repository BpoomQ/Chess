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
 * @author luisa
 */
public class Pawn extends Piece {

    public Pawn(String Color) {
        super(Color);
        type = PieceType.P;
    }

    @Override
    public boolean isValidPath(Position start, Position end, Spot[][] board) {
        if (color.equals("b")) {
            return (start.getJ() == end.getJ()
                    && start.getI() + 1 == end.getI()
                    && board[end.getI()][start.getJ()].getPiece() == null)
                    || (start.getI() + 1 == end.getI()
                    && (start.getJ() + 1 == end.getJ() || start.getJ() - 1 == end.getJ())
                    && board[end.getI()][end.getJ()].getPiece() != null
                    && !board[end.getI()][end.getJ()].getPiece().color.equals(this.color));
        }
        return (start.getJ() == end.getJ()
                && start.getI() - 1 == end.getI()
                && board[end.getI()][end.getJ()].getPiece() == null)
                || (start.getI() - 1 == end.getI()
                && (start.getJ() + 1 == end.getJ() || start.getJ() - 1 == end.getJ())
                && board[end.getI()][end.getJ()].getPiece() != null
                && !board[end.getI()][end.getJ()].getPiece().color.equals(this.color));
    }

    @Override
    public PieceType getType() {
        return type;
    }

}
