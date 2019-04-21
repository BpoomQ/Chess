/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pieces;

import game.Piece;
import game.Player;
import game.PieceType;
import game.Position;

/**
 *
 * @author luisa
 */
public class Knight extends Piece {

    public Knight(String Color) {
        super(Color);
        type = PieceType.K;
    }

    @Override
    public boolean isValidPath(Position start, Position end) {
        return ((start.getI() + 2 == end.getI()) && (start.getJ() + 1 == end.getJ() || start.getJ() - 1 == end.getJ()))
                || ((start.getI() - 2 == end.getI()) && (start.getJ() + 1 == end.getJ() || start.getJ() - 1 == end.getJ()))
                || ((start.getI() + 1 == end.getI() || start.getI() - 1 == end.getI()) && start.getJ() + 2 == end.getJ())
                || ((start.getI() + 1 == end.getI() || start.getI() - 1 == end.getI()) && start.getJ() - 2 == end.getJ());
    }

    @Override
    public PieceType getType() {
        return type;
    }

}
