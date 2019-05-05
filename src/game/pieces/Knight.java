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
public class Knight extends Piece {

    public Knight(String Color) {
        super(Color);
        type = PieceType.K;
    }

    @Override
    public boolean isValidPath(Position start, Position end, Spot[][] board) {
        return (board[end.getI()][end.getJ()].getPiece() != null ? !board[end.getI()][end.getJ()].getPiece().color.equals(this.color) : true)
                && ((start.getI() + 2 == end.getI()) && (start.getJ() + 1 == end.getJ() || start.getJ() - 1 == end.getJ()))
                || ((start.getI() - 2 == end.getI()) && (start.getJ() + 1 == end.getJ() || start.getJ() - 1 == end.getJ()))
                || ((start.getI() + 1 == end.getI() || start.getI() - 1 == end.getI()) && start.getJ() + 2 == end.getJ())
                || ((start.getI() + 1 == end.getI() || start.getI() - 1 == end.getI()) && start.getJ() - 2 == end.getJ());
    }

    @Override
    public PieceType getType() {
        return type;
    }

}
