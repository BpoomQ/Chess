/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pieces;

import game.Piece;
import game.PieceType;
import game.Position;

/**
 *
 * @author luisa
 */
public class Bishop extends Piece {

    public Bishop(String Color) {
        super(Color);
        type = PieceType.B;
    }

    @Override
    public boolean isValidPath(Position start, Position end) {
        return Math.abs(end.getI() - start.getI()) == Math.abs(end.getJ() - start.getJ());
    }

    @Override
    public PieceType getType() {
        return type;
    }

}
